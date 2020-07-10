package com.example.filesystem.service;


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

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FileSystemServiceTest {
	
	
	@Autowired
	FileSystemService fileSystemService;
	
	
	@Test
	public void testfileInfo() {
		try {
			
			String path = new File("src/test/resources/testFolder/testFile.txt").getAbsolutePath();
			FileResponse fileResponse = 
					fileSystemService.getFileInfo(path);
			Assertions.assertNotNull(fileResponse);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfileInfo_pathInvalid() {
		try {
			String path = new File("src/test/resources/testFolder/").getAbsolutePath();
			FileResponse fileResponse = 
					fileSystemService.getFileInfo(path);
			Assertions.assertNotNull(fileResponse);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testPathInfo() {
		try {
			String path = new File("src/test/resources/testFolder/").getAbsolutePath();
			Directory fileResponse = 
					fileSystemService.getPathInfo(path);
			Assertions.assertNotNull(fileResponse);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
