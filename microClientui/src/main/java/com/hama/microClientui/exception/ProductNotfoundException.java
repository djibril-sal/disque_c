/**
 * 
 */
package com.hama.microClientui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author djib8
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotfoundException extends RuntimeException {
	
	public ProductNotfoundException(String message) {
		super(message);
	}

}
