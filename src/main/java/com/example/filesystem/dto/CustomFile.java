package com.example.filesystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomFile {

    private String name;
    
    private String fileSize;
    
    @JsonProperty("fileType")
    private String fileTypeCode;


    public CustomFile(String name,String fileSize,String fileTypeCode ) {
        this.name = name;
        this.fileSize =fileSize;
        this.fileTypeCode =fileTypeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileTypeCode() {
		return fileTypeCode;
	}

	public void setFileTypeCode(String fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}

	@Override
    public String toString() {
        return "CustomFile [name=" + name + "]";
    }
    
}