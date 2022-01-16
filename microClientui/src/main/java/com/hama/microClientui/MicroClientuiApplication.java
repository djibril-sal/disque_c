package com.hama.microClientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.hama")
@EnableEurekaServer
@RibbonClient(name = "microservice-paiement")
public class MicroClientuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroClientuiApplication.class, args);
	}

}
