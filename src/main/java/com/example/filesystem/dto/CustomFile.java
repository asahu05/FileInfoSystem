package com.example.filesystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents an custom file.
 * @author Ajay sahu
 * 
 * 
 * 
*/
public class CustomFile {

    private String name;
    private String fileSize;
    
    @JsonProperty("fileType")
    private char fileTypeCode;

    /**
     * create a custom file with the name, filesize and the filetypecode
     * @param name : an absolute URL giving the base location of the file
     * @param fileSize : type of the file in bytes. 
     * @param fileTypeCode : this flag indicate whether it is a directory or the file
     */
    public CustomFile(String name,String fileSize,char fileTypeCode ) {
        this.name = name;
        this.fileSize =fileSize;
        this.fileTypeCode =fileTypeCode;
    }
    /**
     * Get the an absolute URL giving the base location of the file.
     * @return the name an absolute URL giving the base location of the file
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the an absolute URL giving the base location of the file
     * @param name an absolute URL giving the base location of the file
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the fileSize of the file in bytes
     * @return fileSize : the string containing the fileSize  in bytes
     */

    public String getFileSize() {
		return fileSize;
	}
    
    /**
     * Set the file Size of the file in bytes
     * @param fileSize : fileSize as string 
     */

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 *  Get the file type flag indicate the 'D' or 'F'
	 *  @return file type code as string
	 */

	public char getFileTypeCode() {
		return fileTypeCode;
	}
	/**
	 *  set the file type flag indicate the 'D' or 'F'
	 *  @param fileTypeCode : file type code as string
	 */
	public void setFileTypeCode(char fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}

	@Override
    public String toString() {
        return "CustomFile [name=" + name + "]";
    }
    
}