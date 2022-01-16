package com.hama.microClientui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hama.microClientui.exception.CustomErrorDecoder;

@Configuration
public class FeignExceptionConfig {
	
	@Bean
	public CustomErrorDecoder mCustomErrorDecoder() {
		
		return new  CustomErrorDecoder();
	}

}
