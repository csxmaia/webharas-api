package com.webharas.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Cavalo não disponivel para a venda")
public class CavaloNaoDisponivel extends Exception {
	
}
