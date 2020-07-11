package com.example.filesystem.util;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.filesystem.dto.FileResponse;
import com.example.filesystem.service.FileSystemService;

public class FileUtility {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtility.class);
	
	public static void getBasicFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		
		log.info("getBasicFileAttributes method started {} " , path);
		
		BasicFileAttributes basicFileAttributes =
				Files.readAttributes(path, BasicFileAttributes.class);
		
		fileResponse.setCreationTime(basicFileAttributes.creationTime().toString());
		fileResponse.setIsDirectory(basicFileAttributes.isDirectory());
		fileResponse.setIsOther(basicFileAttributes.isOther());
		fileResponse.setLastAccessTime(basicFileAttributes.lastAccessTime().toString());
		fileResponse.setIsSymbolicLink(basicFileAttributes.isSymbolicLink());
		fileResponse.setIsRegularFile(basicFileAttributes.isRegularFile());
		fileResponse.setSize(basicFileAttributes.size());
		
		log.info("getBasicFileAttributes method ended {} " );
	}
	
	public static void getDosFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		log.info("getDosFileAttributes method started {} " , path);
		
		DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
		if(null != dosFileAttributeView) {
			log.debug("setting up the file permission for Dos OS");
			
			DosFileAttributes dosFileAttributes = dosFileAttributeView.readAttributes();
			if(dosFileAttributes.isReadOnly()) fileResponse.getOwnerPermission().add("READ");
			fileResponse.setHidden(dosFileAttributes.isHidden());
			fileResponse.setArchive(dosFileAttributes.isArchive());
		}
		log.info("getDosFileAttributes method ended ");
	}
	
	public static void getFileStoreAttributes(Path path, FileResponse fileResponse) throws IOException {
		
		log.info("getFileStoreAttributes method started {} " , path);
		FileStore store = Files.getFileStore(path);

		if(null != store) {
			long total = store.getTotalSpace() / 1024;
		    long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
		    long avail = store.getUsableSpace() / 1024;
		    
		    fileResponse.setTotalSpace(total);
		    fileResponse.setUsedSpace(used);
		    fileResponse.setAvailableSpace(avail);
		}
	    
	    log.info("getFileStoreAttributes method ended ");
	}
	
	public static void getFileOwnerAttributes(Path path, FileResponse fileResponse) throws IOException {
		log.info("getFileOwnerAttributes method started {} " , path);
		
		FileOwnerAttributeView fileOwnerAttributeView = 
				Files.getFileAttributeView(path, FileOwnerAttributeView.class);
		UserPrincipal userPrincipal = fileOwnerAttributeView.getOwner();
		
		fileResponse.setOwner(userPrincipal.getName());
		
		log.info("getFileOwnerAttributes method ended ");
		
	}
	
	public static void getPosixFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		log.info("getPosixFileAttributes method started {} " , path);
		
		PosixFileAttributeView posixFileAttributesView = 
				Files.getFileAttributeView(path, PosixFileAttributeView.class);
		
		if(posixFileAttributesView != null) {
			log.info("setting up the file permission for unix based OS");
			
			PosixFileAttributes posixFileAttributes = posixFileAttributesView.readAttributes();
			fileResponse.setName(posixFileAttributes.owner().getName());
			fileResponse.setOwnerPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("OWNER"))
					.map(s -> s.toString().substring(s.toString().indexOf("_") + 1))
					.collect(Collectors.toList()));
			fileResponse.setGroupPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("GROUP"))
					.map(s -> s.toString().substring(s.toString().indexOf("_") + 1))
					.collect(Collectors.toList()));
			fileResponse.setAllPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("OTHERS"))
					.map(s -> s.toString().substring(s.toString().indexOf("_") + 1))
					.collect(Collectors.toList()));
		}
		
		log.info("getPosixFileAttributes method ended ");
	}
}
