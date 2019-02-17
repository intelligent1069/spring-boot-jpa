package com.intelligent1069.spring.jpa.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String error;
	private String message;

	
	public ExceptionResponse(Date timestamp, String error, String message) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
		
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}


	



}
