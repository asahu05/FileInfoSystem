package com.example.filesystem.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)

public class GlobalExceptionHandlerTest {
	
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;
	
	
	@Test
	public void testApplicationException() {
		Error error = new Error();
		error.setMessage("testApplicationException");
		ApplicationException applicationException = new ApplicationException(error.getMessage());
		Error responseError = globalExceptionHandler.applicationException(applicationException);
		assertEquals("testApplicationException",responseError.getMessage());
	}
	
	@Test
	public void testClientException() {
		Error error = new Error();
		error.setMessage("testClientException");
		ClientException clientException = new ClientException(error.getMessage());
		Error responseError = globalExceptionHandler.clientException(clientException);
		assertEquals("testClientException",responseError.getMessage());
	}

}
