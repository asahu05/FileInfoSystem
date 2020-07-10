package com.example.filesystem.util;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.filesystem.dto.FileResponse;

public class FileUtilities {
	
	public static void getBasicFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		BasicFileAttributes basicFileAttributes =
				Files.readAttributes(path, BasicFileAttributes.class);
		
		fileResponse.setCreationTime(basicFileAttributes.creationTime().toString());
		fileResponse.setIsDirectory(basicFileAttributes.isDirectory());
		fileResponse.setIsOther(basicFileAttributes.isOther());
		fileResponse.setLastAccessTime(basicFileAttributes.lastAccessTime().toString());
		fileResponse.setIsSymbolicLink(basicFileAttributes.isSymbolicLink());
		fileResponse.setIsRegularFile(basicFileAttributes.isRegularFile());
		fileResponse.setSize(basicFileAttributes.size());
	}
	
	public static void getDosFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
		if(null != dosFileAttributeView) {
			DosFileAttributes dosFileAttributes = dosFileAttributeView.readAttributes();
			if(dosFileAttributes.isReadOnly()) fileResponse.getOwnerPermission().add("READ");
			fileResponse.setHidden(dosFileAttributes.isHidden());
			fileResponse.setArchive(dosFileAttributes.isArchive());
		}
	}
	
	public static void getFileStoreAttributes(Path path, FileResponse fileResponse) throws IOException {
		FileStore store = Files.getFileStore(path);

	    long total = store.getTotalSpace() / 1024;
	    long used = (store.getTotalSpace() -
	                 store.getUnallocatedSpace()) / 1024;
	    long avail = store.getUsableSpace() / 1024;
	    
	    fileResponse.setTotalSpace(total);
	    fileResponse.setUsedSpace(used);
	    fileResponse.setAvailableSpace(avail);
		
	}
	
	public static void getFileOwnerAttributes(Path path, FileResponse fileResponse) throws IOException {
		FileOwnerAttributeView fileOwnerAttributeView = 
				Files.getFileAttributeView(path, FileOwnerAttributeView.class);
		UserPrincipal userPrincipal = fileOwnerAttributeView.getOwner();
		
		fileResponse.setOwner(userPrincipal.getName());
	}
	
	public static void getPosixFileAttributes(Path path, FileResponse fileResponse) throws IOException {
		PosixFileAttributeView posixFileAttributesView = 
				Files.getFileAttributeView(path, PosixFileAttributeView.class);
		if(posixFileAttributesView != null) {
			PosixFileAttributes posixFileAttributes = posixFileAttributesView.readAttributes();
			fileResponse.setName(posixFileAttributes.owner().getName());
			fileResponse.setOwnerPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("OWNER"))
					.map(s -> s.toString().substring(s.toString().indexOf("_")+1))
					.collect(Collectors.toList()));
			fileResponse.setGroupPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("GROUP"))
					.map(s -> s.toString().substring(s.toString().indexOf("_")+1))
					.collect(Collectors.toList()));
			fileResponse.setAllPermission(posixFileAttributes.permissions().stream()
					.filter(permission -> permission.toString().startsWith("OTHERS"))
					.map(s -> s.toString().substring(s.toString().indexOf("_")+1))
					.collect(Collectors.toList()));
		}
	}
}
