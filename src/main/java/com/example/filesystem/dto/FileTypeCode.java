package com.example.filesystem.dto;

/**
 * Type of the file or directory.
 * @author Ajay Sahu
 *
 */
public enum FileTypeCode {
	/**
	 * Type of the file and directory will be 'F' and 'D'
	 */
	DIRECTORY("D", "directory"),
	FILE("F","file");

	private String code;
	private String name;

	/**
	 * Get the code of the file or directory.
	 * @return code the code of file or directory.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Set the code of the file or directory.
	 * @param code the code of file or directory.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the name of the file or directory.
	 * @return name the name of file or directory.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the file or directory.
	 * @param name the name of file or directory.
	 */
	public void setName(String name) {
		this.name = name;
	}

	FileTypeCode(String code, String name) {
	    this.name = name;
	    this.code = code;
	  }
}
