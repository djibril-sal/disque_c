package com.hama.Produit.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hama.Produit.configuration.ApplicationPropertiesConfiguration;
import com.hama.Produit.exception.ProduitNotFoundException;
import com.hama.Produit.model.Product;
import com.hama.Produit.repository.ProductDao;



@RestController
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ApplicationPropertiesConfiguration appProperties;
	
	@RequestMapping(value = "/Produits", method = RequestMethod.GET)
	public List<Product> getProducts() {
		
		logger.info("GET / liste de produits ");
		
		List<Product> products = productDao.findAll();
		
		if(products.isEmpty()) throw new ProduitNotFoundException("Aucun produit n'existe dans la base de donnée !");
		
		List<Product> listeLimitee = products.subList(0, appProperties.getLimitDeProduits());
		
		logger.warn("Il n'y aucun produit ");
		return listeLimitee;
	}
	
	@RequestMapping(value = "/Produits/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable Integer id) {
		
		logger.info("GET / liste des produits par ID");
		
		Optional<Product> product = productDao.findById(id);
		
		if(!product.isPresent()) throw new ProduitNotFoundException("Le produit de l'id " +id+ " n'existe pas !");
		
		logger.warn("le produit avec cette {} ", id);
		
		return product;
		
	}
	
	
	@PostMapping(value = "/Produits")
	public ResponseEntity<Void> createProduct(@RequestBody Product product) {
		
		logger.info("POST / création de produit ");
		
		Product produit = productDao.save(product);
		
		if(produit == null)
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id")
				.buildAndExpand(produit.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
				
	}
	
	@PutMapping( value = "/Produits")
    public void updateProduct(@RequestBody Product product) {
    	
		logger.info("PUT / mettre à jour un produit");
    	productDao.save(product);
    }
	
	@DeleteMapping(value = "/Produits/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) throws ProduitNotFoundException {
		
		logger.info("DELETE / supprimer un produit");
		
		Product produit = productDao.findById(id)
				.orElseThrow(() -> new ProduitNotFoundException("le produit de l'id " +id+ " n'existe pas !"));
				
		productDao.delete(produit);
		
		return ResponseEntity.noContent().build();
		
	}
		
	
	
	
	
		
		
	

}
