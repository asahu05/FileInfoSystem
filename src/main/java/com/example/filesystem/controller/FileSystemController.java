package com.example.filesystem.controller;


import java.io.IOException;

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

    @GetMapping("/pathInfo")
    public Directory getPathInfo(@RequestParam("path") String path) throws IOException {
        return (Directory) fileSystemService.getPathInfo(path);
    }
    
    @GetMapping("/fileInfomation")
    public FileResponse getFileInfo(@RequestParam("file") String path) throws Exception {
    	return fileSystemService.getFileInfo(path);
    }
}
