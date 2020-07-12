package com.example.filesystem.exception;

/**
 * Generic response for the exception raised by service class.
 *
 * @author Ajay Sahu
 */
public class Error {
	
	private String code;
	private String message;
	
	/**
	 * Get the code of the error.
	 * @return code the code of error.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Set the code of the error.
	 * @param code the code of error.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Get the message of the error.
	 * @return message the message of error.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Set the message of the error.
	 * @param message the message of error.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
