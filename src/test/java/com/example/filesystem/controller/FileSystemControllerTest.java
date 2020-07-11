package com.example.filesystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.filesystem.service.FileSystemService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FileSystemController.class)
public class FileSystemControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	FileSystemService fileSystemService ;
	
	
	@Test
	 void whenValidInput_file_path_thenReturns200() throws Exception {
		String path = new File("src/test/resources/testFolders").getAbsolutePath();
		mockMvc.perform(get("/api/pathInfo").param("path", path)
			    .contentType("api/application/json"))
			    .andExpect(status().isOk());
	  }
	
	
	@Test
	 void whenValidInput_file_info_thenReturns200() throws Exception {
		String path = new File("src/test/resources/testFolder/testFile.txt").getAbsolutePath();
		mockMvc.perform(get("/api/fileInfo").param("file", path)
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	  }

	@Test
	 void whenValidInput_file_path_thenReturns400() throws Exception {
		String path = new File("src/test/resources/testFolder/testFile.txt").getAbsolutePath();
		mockMvc.perform(get("/api/fileInfo").param("path", path)
			    .contentType("api/application/json"))
			    .andExpect(status().isBadRequest());
	  }

	
	

}
