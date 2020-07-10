package com.example.filesystem.service;


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
			FileResponse fileResponse = 
					fileSystemService.getFileInfo("/Users/ajaysahu/AngularTutorial/gallery/app/showcase/pin.showcase.component.ts");
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
			FileResponse fileResponse = 
					fileSystemService.getFileInfo("/fileinfosystem/src/test/java/com/example/");
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
			Directory fileResponse = 
					fileSystemService.getPathInfo("/Users/ajaysahu/AngularTutorial/gallery/app/showcase/");
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
