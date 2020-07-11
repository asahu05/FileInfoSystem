package com.example.filesystem.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
 	@ExceptionHandler(ApplicationException.class)
 	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ResponseBody
    public Error applicationException(ApplicationException ex) {
 	   Error error = new Error();
       error.setCode("Server Exception");
       error.setMessage(ex.getMessage());
       return error; 	         
    }
 	
	@ExceptionHandler(ClientException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ResponseBody
    public Error clientException(ClientException ex) {
 	   Error error = new Error();
       error.setCode("Bad Request");
       error.setMessage(ex.getMessage());
       return error;       
         
    }
}
