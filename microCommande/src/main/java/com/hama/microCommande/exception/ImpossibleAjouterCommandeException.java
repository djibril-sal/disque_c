package com.hama.microCommande.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterCommandeException extends Exception {
	
	public ImpossibleAjouterCommandeException (String message) {
		super(message);
	}

}
