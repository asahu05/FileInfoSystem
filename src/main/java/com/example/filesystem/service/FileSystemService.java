package com.example.filesystem.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.filesystem.dto.CustomFile;
import com.example.filesystem.dto.Directory;
import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.dto.FileTypeCode;
import com.example.filesystem.util.FileUtilities;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by ajaysahu on 07/07/2020.
 */
@Service
public class FileSystemService {

	private static final Logger log = LoggerFactory.getLogger(FileSystemService.class);
	
    public Directory getPathInfo(String path) throws IOException {
        Directory parentFolder = new Directory(path,FileTypeCode.DIRECTORY.getCode());
        Directory pathInformation = displayPathDetails(parentFolder);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(pathInformation));
        return pathInformation;
    }


    public FileResponse getFileInfo(String file) throws Exception {
    	
    	if(new File(file).isDirectory()) {
    		log.error("path is invalid");
    		throw new Exception("please enter the valid file path");
    	}
	
		FileResponse fileResponse = new FileResponse();
		
		Path filePath = Paths.get(file);
		FileUtilities.getBasicFileAttributes(filePath, fileResponse);
		FileUtilities.getDosFileAttributes(filePath, fileResponse);
		FileUtilities.getFileOwnerAttributes(filePath, fileResponse);
		FileUtilities.getFileStoreAttributes(filePath, fileResponse);
		FileUtilities.getPosixFileAttributes(filePath, fileResponse);
        
		return  fileResponse;
	}
	
	
	private static Directory displayPathDetails(Directory parentFolder) throws IOException {
        File node = new File(parentFolder.getName());
        if (node.isDirectory()) {
            File[] subNote = node.listFiles();
            for (File filename : subNote) {
                if(filename.isDirectory()){
                    Directory folder = new Directory(filename.getAbsolutePath(),FileTypeCode.DIRECTORY.getCode());
                    
                    parentFolder.addFolder(folder);
                    displayPathDetails(folder);
                } else {
                	String fileSize =  filename.length() +" bytes";
                    parentFolder.addFile(new CustomFile(filename.getAbsolutePath(),fileSize,FileTypeCode.FILE.getCode()));
                }
            }
        }
        return parentFolder;
    }
}
