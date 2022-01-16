package com.hama.mProduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hama.mProduit.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
	
}
