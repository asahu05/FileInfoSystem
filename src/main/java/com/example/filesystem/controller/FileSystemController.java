package com.example.filesystem.controller;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.filesystem.dto.Directory;
import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.service.FileSystemService;



/**
 * Created by ajaysahu on 07/07/2020.
 */
@RestController
public class FileSystemController {

    @Autowired private FileSystemService fileSystemService;
    
    private static final Logger log = LoggerFactory.getLogger(FileSystemController.class);

    @GetMapping("/api/pathInfo")
    public Directory getPathInfo(@RequestParam("path") String path) throws IOException {
    	log.info("getPathInfo method to traverse the folder {}" ,path);
        return (Directory) fileSystemService.getPathInfo(path);
    }
    
    @GetMapping("/api/fileInfo")
    public FileResponse getFileInfo(@RequestParam("file") String path) throws Exception {
    	log.info("getFileInfo method to get the file information  {}" ,path);
    	return fileSystemService.getFileInfo(path);
    }
}
