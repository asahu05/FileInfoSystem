package com.example.filesystem.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.filesystem.dto.Directory;
import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.exception.ApplicationException;
import com.example.filesystem.exception.ClientException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FileSystemServiceTest {
	
	
	@Autowired
	FileSystemService fileSystemService;
	
	
	@Test
	public void testfileInfo() throws Exception {
			
		String path = new File("src/test/resources/testFolder/testFile.txt").getAbsolutePath();
		FileResponse fileResponse = 
				fileSystemService.getFileInfo(path);
		Assertions.assertNotNull(fileResponse);	
	}
	
	
	
	@Test()
	public void testfileInfo_pathInvalid() throws Exception {
		
		String path = new File("src/test/resources/testFolder/").getAbsolutePath();
		 Throwable exception = assertThrows(ClientException.class, () -> {
			 fileSystemService.getFileInfo(path);
		    });
				
		 assertEquals("Please enter the valid file path", exception.getMessage());
	}
	
	
	@Test()
	public void test_getPathInfo_pathInvalid() throws Exception {
		
		String path = new File("src/test/resources/testFold").getAbsolutePath();
		 Throwable exception = assertThrows(ClientException.class, () -> {
			 fileSystemService.getPathInfo(path);
		    });
				
		 assertEquals("Please enter the valid the path to folder", exception.getMessage());
	}
	
	
	@Test
	public void testPathInfo() throws IOException {
		
			String path = new File("src/test/resources/testFolder/").getAbsolutePath();
			Directory fileResponse = 
					fileSystemService.getPathInfo(path);
			Assertions.assertNotNull(fileResponse);	
		
	}
	
//	@Test
//	public void testFileInfo_Exception() throws IOException {
//		
//		String path = new File("src/test/resources/testFolder/testFile.txt").getAbsolutePath();
//		Throwable exception = assertThrows(ApplicationException.class, () -> {
//			 fileSystemService.getFileInfo(path);
//		    });
//		assertEquals("File reading exception", exception);
//			
//	}
	

}
