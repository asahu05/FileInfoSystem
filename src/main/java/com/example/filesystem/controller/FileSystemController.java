package com.example.filesystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.filesystem.dto.Directory;
import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.exception.ApplicationException;
import com.example.filesystem.service.FileSystemService;



/**
 * Controller for the exposing links to the file system resources.
 *
 * @author Ajay Sahu
 */

@RestController
public class FileSystemController {
	
	

    @Autowired private FileSystemService fileSystemService;
    
    private static final Logger log = LoggerFactory.getLogger(FileSystemController.class);

    /**
     * <code>GET /api/pathInfo?path={path}</code> - Exposes links to traverse the directory.
     * @param path an absolute URL giving the base location of the directory
     * @return {@link Directory} 
     * @throws ApplicationException If method throws application exception 
     */
    @GetMapping("/api/pathInfo")
    public Directory getPathInfo(@RequestParam("path") String path) throws ApplicationException {
    	log.info("getPathInfo method to traverse the folder {}" ,path);
        return (Directory) fileSystemService.getPathInfo(path);
    }
    
    /**
     * <code>GET /api/fileInfo?file={path}</code> - Exposes links to get the all JDK attribute of the file.
     * @param path an absolute URL giving the base location of the file
     * @return {@link FileResponse}
     * @throws ApplicationException If method throws application exception 
     */
    @GetMapping("/api/fileInfo")
    public FileResponse getFileInfo(@RequestParam("file") String path) throws ApplicationException {
    	log.info("getFileInfo method to get the file information  {}" ,path);
    	return fileSystemService.getFileInfo(path);
    }
}
