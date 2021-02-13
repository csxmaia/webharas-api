package com.webharas.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Email ou senha incorretos")
public class FailedAuth extends Exception {
	
}
