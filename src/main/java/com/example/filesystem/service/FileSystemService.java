package com.example.filesystem.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.filesystem.dto.CustomFile;
import com.example.filesystem.dto.Directory;
import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.dto.FileTypeCode;
import com.example.filesystem.exception.ApplicationException;
import com.example.filesystem.exception.ClientException;
import com.example.filesystem.util.FileUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by ajaysahu on 07/07/2020.
 */
@Service
public class FileSystemService {

	private static final Logger log = LoggerFactory.getLogger(FileSystemService.class);
	
    public Directory getPathInfo(String path) throws ApplicationException {
    	log.info("getPathInfo method started {} " , path);
    	
    	if(!new File(path).exists()) {
    		log.error("path is invalid {} ",path);
    		throw new ClientException("Please enter the valid the path to folder");
    	}	
    	
        Directory parentFolder = new Directory(path,FileTypeCode.DIRECTORY.getCode());
        Directory pathInformation = displayPathDetails(parentFolder);
        log.info("getPathInfo method ended");
        return pathInformation;
    }


    public FileResponse getFileInfo(String file) throws ApplicationException {
    	log.info("getFileInfo method started {} " , file);
    	
    	if(new File(file).isDirectory()) {
    		log.error("File is invalid {} ", file);
    		throw new ClientException("Please enter the valid file path");
    	}
	
		FileResponse fileResponse = new FileResponse();
		
		Path filePath = Paths.get(file);
		
		try {
			FileUtility.getBasicFileAttributes(filePath, fileResponse);
			FileUtility.getDosFileAttributes(filePath, fileResponse);
			FileUtility.getFileOwnerAttributes(filePath, fileResponse);
			FileUtility.getFileStoreAttributes(filePath, fileResponse);
			FileUtility.getPosixFileAttributes(filePath, fileResponse);
		} catch(IOException ioe) {
			throw new ApplicationException("File reading exception", ioe);
		}
		
		log.info("getFileInfo method ended");
		
		return  fileResponse;
	}
	
	
	private static Directory displayPathDetails(Directory parentFolder) {
		log.info("displayPathDetails started {}" ,parentFolder);
        File node = new File(parentFolder.getName());
        if (node.isDirectory()) {
            File[] subNote = node.listFiles();
            for (File filename : subNote) {
                if(filename.isDirectory()){
                    Directory folder = new Directory(filename.getAbsolutePath(),FileTypeCode.DIRECTORY.getCode());
                    log.info("displayPathDetails  directory{} " ,folder.getName());
                    parentFolder.addFolder(folder);
                    displayPathDetails(folder);
                } else {
                	String fileSize =  filename.length() +" bytes";
                	CustomFile customFile = new CustomFile(filename.getAbsolutePath(),fileSize,FileTypeCode.FILE.getCode());
                    log.info("displayPathDetails  file {} " ,customFile.getName());
                    parentFolder.addFile(customFile);
                }
            }
        }
       log.info("displayPathDetails ended " ); 
    	return parentFolder;
    }
}
