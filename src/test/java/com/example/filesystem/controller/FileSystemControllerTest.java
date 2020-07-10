package com.example.filesystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		mockMvc.perform(get("/pathInfo").param("path", "C:\\CLR-Release")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	  }
	
	
	@Test
	 void whenValidInput_file_info_thenReturns200() throws Exception {
		mockMvc.perform(get("/fileInfomation").param("file", "C:\\CLR-Release\\C:\\CLR-Release\\Application-meta\\export (10).csv")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	  }

	

	
	

}
