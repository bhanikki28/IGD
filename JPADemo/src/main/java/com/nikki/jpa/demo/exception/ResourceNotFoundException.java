package com.nikki.jpa.demo.exception;




public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -897350780964401348L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	private String errorCode;

	public ResourceNotFoundException(String message, String errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

}
