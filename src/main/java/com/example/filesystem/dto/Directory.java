package com.example.filesystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents a directory.
 * @author Ajay sahu
 * 
 * 
 * 
*/
public class Directory {

    private String name;
    
    @JsonInclude(Include.NON_EMPTY)
	private List<CustomFile> files;
    
	@JsonProperty("directory")
	@JsonInclude(Include.NON_EMPTY)
    private List<Directory> folders;

    @JsonProperty("fileType")
    private char fileTypeCode;
    
    /**
     * create a directory with the name and filetypecode
     * @param name : an absolute URL giving the base location of the director
     * @param fileTypeCode : this flag indicate whether it is a directory or the file
     */

    public Directory(String name, char fileTypeCode) {
        files = new ArrayList<>();
        folders = new ArrayList<>();
        this.name = name;   
        this.fileTypeCode =fileTypeCode;
    }
    /**
     * Get the fileTypeCode of the file.
     * @return fileTypeCode : file type code as string
     */
    public char getFileTypeCode() {
		return fileTypeCode;
	}
    /**
     * Set the file type code of the file.
     * @param fileTypeCode : file type code as string 
     */
	public void setFileTypeCode(char fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}
	/**
     * Get the an absolute URL giving the base location of the directory
     * @return the name : an absolute URL giving the base location of the directory
     */
	public String getName() {
        return name;
    }
	 /**
     * Set the an absolute URL giving the base location of the directory
     * @param name an absolute URL giving the base location of the directory
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the list of the custom files of a directory
     * @return List of the custom files
     */
    public List<CustomFile> getFiles() {
        return files;
    }
    /**
     * Add a custom file to the arrayList
     * @param file {@link CustomFile}
     */

    public void addFile(CustomFile file) {
        this.files.add(file);
    }
    /**
     * Get the list of the directories of a directory
     * @return List of the folder of the directory
     */
    public List<Directory> getFolders() {
        return folders;
    }
    /**
     * Add a directory to the arrayList
     * @param folder {@link Directory}
     */

    public void addFolder(Directory folder) {
        this.folders.add(folder);
    }
    
    @Override
    public String toString() {
        return "CustomFolder [name=" + name + ", files=" + files + ", folders=" + folders + "]";

    }
    
}