package com.example.reeceaddressbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddressTypeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	 public AddressTypeNotFoundException(String message) { 
		 super(message);
	 }
	
}
