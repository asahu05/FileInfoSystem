package com.example.filesystem.exception;

/**
 * Exception for errors that fit response status 400 (bad request).
 *
 * @author Ajay Sahu
 */
@SuppressWarnings("serial")
public class ClientException extends RuntimeException {

	
	/** 
	 * Constructs a new application exception with the specified cause
	 * 
	 * @param e exception thrown from method
     */
	public ClientException(Exception e) {
        super(e);
    }
	 
	/** Constructs a new application exception with the specified detail message.
     * 
     * @param cause   the detail message.
     */
    public ClientException(String cause) {
        super(cause);
    }   
}
