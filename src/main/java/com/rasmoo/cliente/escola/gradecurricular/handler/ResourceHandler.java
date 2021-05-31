package com.rasmoo.cliente.escola.gradecurricular.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rasmoo.cliente.escola.gradecurricular.exception.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.model.ErrorResponse;


@ControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(MateriaException.class)
	public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException m){
		//ErrorResponseBuilder erro = ErrorResponse.builder();
		
		return ResponseEntity.status(null).body(null);
	}
}
