package com.rasmoo.cliente.escola.gradecurricular.model;

import lombok.Builder;

@Builder
public class ErrorResponse {

	private String Mensagem;
	private int httpStatus;
	private long timeStamp;
}
