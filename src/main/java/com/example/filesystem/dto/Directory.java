package com.example.filesystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Directory {

    private String name;
    
    @JsonInclude(Include.NON_EMPTY)
	private List<CustomFile> files;
    
	@JsonProperty("directory")
	@JsonInclude(Include.NON_EMPTY)
    private List<Directory> folders;

    @JsonProperty("fileType")
    private String fileTypeCode;

    public Directory(String name,String fileTypeCode) {
        files = new ArrayList<>();
        folders = new ArrayList<>();
        this.name = name;   
        this.fileTypeCode =fileTypeCode;
    }
    
    public String getFileTypeCode() {
		return fileTypeCode;
	}

	public void setFileTypeCode(String fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomFile> getFiles() {
        return files;
    }

    public void addFile(CustomFile file) {
        this.files.add(file);
    }

    public List<Directory> getFolders() {
        return folders;
    }

    public void addFolder(Directory folder) {
        this.folders.add(folder);
    }
    
    @Override
    public String toString() {
        return "CustomFolder [name=" + name + ", files=" + files + ", folders=" + folders + "]";

    }
    
}