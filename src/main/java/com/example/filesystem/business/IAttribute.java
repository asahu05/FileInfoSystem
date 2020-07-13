package com.example.filesystem.business;

import java.io.IOException;
import java.nio.file.Path;

import com.example.filesystem.dto.FileResponse;

/**
 * This interface will be called from the service layer.
 * 
 */

public interface IAttribute {
	
	/**
	 * Use to get the available JDK attributes of a file
	 * @param path  an absolute URL giving the base location of the image
	 * @param fileResponse  response object which fills up with attribute
	 * @throws IOException  If any method throws IOException 
	 */

	public void getFileAttributes(Path path, FileResponse fileResponse) throws IOException; 
}
