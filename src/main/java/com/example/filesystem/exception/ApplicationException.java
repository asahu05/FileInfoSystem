package com.example.filesystem.exception;

public class ApplicationException extends RuntimeException {
	
	public ApplicationException(Exception e) {
        super(e);
    }
    public ApplicationException(String cause) {
        super(cause);
    }
    
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
   
}
