package com.webharas.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "Existem dados vazios nesse registro")
public class NullPointerException extends Exception {
	
}
