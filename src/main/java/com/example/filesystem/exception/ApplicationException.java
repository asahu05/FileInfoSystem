package com.example.filesystem.exception;

/**
 * Exception for errors that fit response status 500 (server error).
 *
 * @author Ajay Sahu
 */
@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {
	
	/** 
	 * Constructs a new application exception with the specified cause
	 * 
	 * @param e exception throws by method
     */
	public ApplicationException(Exception e) {
        super(e);
    }
	
	/** Constructs a new application exception with the specified detail message.
     * 
     * @param message the detail message.
     */
    public ApplicationException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     * @param message the detail message
     * @param cause the cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
   
}
