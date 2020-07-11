package com.example.filesystem.exception;

public class ClientException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientException(Exception e) {
        super(e);
     }
	 
     public ClientException(String cause) {
        super(cause);
     }   
}
