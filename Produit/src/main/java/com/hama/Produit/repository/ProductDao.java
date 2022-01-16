package com.hama.Produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hama.Produit.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
	
}
