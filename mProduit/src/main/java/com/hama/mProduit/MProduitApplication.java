package com.hama.mProduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.hama.mProduit.repository.ProductDao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaServer
public class MProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MProduitApplication.class, args);
	}

}
