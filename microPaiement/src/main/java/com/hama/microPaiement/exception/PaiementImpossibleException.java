package com.hama.microPaiement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PaiementImpossibleException extends Exception {
	
	public PaiementImpossibleException (String message) {
		super(message);
	}

}
