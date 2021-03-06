package com.hama.microClientui.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	
	private final ErrorDecoder defaultErrorDecoder = new Default();
	
	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		
		if (response.status() == 404) {
			return new ProductNotfoundException("Produit non trouvé !");
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}

}
