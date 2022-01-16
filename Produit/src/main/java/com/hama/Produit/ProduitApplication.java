package com.hama.Produit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@ComponentScan("com.hama.Produit.repository.ProductDao")
@RefreshScope

public class ProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
	}

}
