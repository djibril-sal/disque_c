package com.hama.microClientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hama.microClientui.beans.ProductBean;
import com.hama.microClientui.proxies.microserviceProductProxy;

@Controller
public class ClientController {
	
	@Autowired
	microserviceProductProxy microserviceProductP;
	
	@GetMapping(value = "/Accueil")
	public String accueil(Model model) {
		
		List<ProductBean> produits = microserviceProductP.getProducts();
		
		model.addAttribute("produits", produits);
		
		return "Accueil";
	}
	
	

}
