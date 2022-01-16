package com.hama.microPaiement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroPaiementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPaiementApplication.class, args);
	}

}
