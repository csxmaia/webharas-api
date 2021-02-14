package com.webharas.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Há campos obrigatórios não preenchidos")
public class NotNullException extends Exception {
	
}
