package com.hama.microClientui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hama.microClientui.beans.ProductBean;


@FeignClient(name = "microservice-produits")

public interface microserviceProductProxy {
	
	 @RequestMapping(value = "/Produits", method = RequestMethod.GET)
	 List<ProductBean> getProducts();
	 
	 @RequestMapping(value = "/Produits/{id}", method = RequestMethod.GET)
	 ProductBean getProductById(@PathVariable int id);

}
