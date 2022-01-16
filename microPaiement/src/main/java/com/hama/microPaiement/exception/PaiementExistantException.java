package com.hama.microPaiement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PaiementExistantException extends RuntimeException {

	
	public PaiementExistantException (String message) {
		super(message);
	}
}
