package com.example.filesystem.dto;

public enum FileTypeCode {
	DIRECTORY("D", "directory"),
	FILE("F","file");

	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	FileTypeCode(String code, String name) {
	    this.name = name;
	    this.code = code;
	  }
}
