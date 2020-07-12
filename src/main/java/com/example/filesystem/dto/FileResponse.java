package com.example.filesystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Represent the response of the file attributes
 *  @author ajaysahu
 */

public class FileResponse {
	
	@JsonInclude(Include.NON_NULL)
	private String owner ;
	@JsonInclude(Include.NON_NULL)
	private String creationTime ;
	@JsonInclude(Include.NON_NULL)
	private String lastAccessTime;
	@JsonInclude(Include.NON_NULL)
	private String lastModifiedTime;
	private boolean isDirectory;
    private boolean isOther;
	private boolean isRegularFile;
	private boolean isSymbolicLink;
	private long size;
	private long totalSpace;
	private long usedSpace;
	private long availableSpace;
	@JsonInclude(Include.NON_EMPTY)
	private List ownerPermission;
	@JsonInclude(Include.NON_EMPTY)
	private List groupPermission;
	@JsonInclude(Include.NON_EMPTY)
	private List AllPermission;
	private boolean isArchive;
	private boolean isHidden;
	private String name;
	
	 /**
     * Get the Creation time of the file 
     * @return String creationTime of the file
     */
	public String getCreationTime() {
		return creationTime;
	}
	
	 /**
     * Set the Creation time of the file 
     * @param string creationTime of the file
     */
	public void setCreationTime(String string) {
		this.creationTime = string;
	}
	
	 /**
     * Get the lastAccessTime of the file 
     * @return String lastAccessTime of the file
     */
	public String getLastAccessTime() {
		return lastAccessTime;
	}
	
	 /**
     * Set the lastAccessTime of the file 
     * @param string lastAccessTime of the file
     */
	public void setLastAccessTime(String string) {
		this.lastAccessTime = string;
	}
	
	 /**
     * Get the lastModifiedTime of the file 
     * @return lastModifiedTime Last Modified Time of the file
     */
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}
	
	 /**
     * Set the lastModifiedTime of the file 
     * @param lastModifiedTime Last Modified Time of the file
     */
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	
	 /**
     * Get the isDirectory of the file 
     * @return boolean isDirectory 
     */
	public boolean getIsDirectory() {
		return isDirectory;
	}
	
	 /**
     * Set the isDirectory of the file 
     * @param isDirectory as boolean value 
     */
	public void setIsDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	
	 /**
     * Get the isOther of the file 
     * @return isOther as boolean 
     */
	public boolean getIsOther() {
		return isOther;
	}
	
	/**
     * Set the isOther of the file 
     * @param isOther as boolean 
     */
	public void setIsOther(boolean isOther) {
		this.isOther = isOther;
	}
	
	 /**
     * Get the isRegularFile of the file 
     * @return isRegularFile as boolean 
     */
	public boolean getIsRegularFile() {
		return isRegularFile;
	}
	
	/**
     * Set the isRegularFile of the file 
     * @param isRegularFile as boolean 
     */
	public void setIsRegularFile(boolean isRegularFile) {
		this.isRegularFile = isRegularFile;
	}
	
	 /**
     * Get the isSymbolicLink of the file 
     * @return isSymbolicLink is symbolic Link 
     */
	public boolean getIsSymbolicLink() {
		return isSymbolicLink;
	}
	
	 /**
     * Set the isSymbolicLink of the file 
     * @param isSymbolicLink is link symbolic 
     */
	public void setIsSymbolicLink(boolean isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}
	
	 /**
     * Get the size of the file 
     * @return long  size 
     */
	public long getSize() {
		return size;
	}
	
	 /**
     * Set the size of the file 
     * @param l file size 
     */
	public void setSize(long l) {
		this.size = l;
	}
	
	/**
     * Get the owner of the file 
     * @return String  owner 
     */
	public String getOwner() {
		return owner;
	}
	
	/**
     * Set the owner of the file 
     * @param owner who created the file 
     */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	 /**
     * Get the totalSpace of the file 
     * @return long  totalSpace 
     */
	
	public long getTotalSpace() {
		return totalSpace;
	}
	
	 /**
     * Set the totalSpace of the file 
     * @param totalSpace total space of the file 
     */
	public void setTotalSpace(long totalSpace) {
		this.totalSpace = totalSpace;
	}
	
	 /**
     * Get the usedSpace of the file 
     * @return usedSpace used space of the file 
     */
	public long getUsedSpace() {
		return usedSpace;
	}
	
	/**
     * Set the usedSpace of the file 
     * @param usedSpace used space of the file 
     */
	public void setUsedSpace(long usedSpace) {
		this.usedSpace = usedSpace;
	}
	
	 /**
     * Get the availableSpace of the file 
     * @return availableSpace available space of the file 
     */
	public long getAvailableSpace() {
		return availableSpace;
	}
	
	 /**
     * Set the availableSpace of the file 
     * @param availableSpace available space of the file 
     */
	public void setAvailableSpace(long availableSpace) {
		this.availableSpace = availableSpace;
	}
	
	 /**
     * Get the isArchive of the file 
     * @return isArchive is file archive 
     */
	public boolean isArchive() {
		return isArchive;
	}
	
	 /**
     * Set the isArchive of the file 
     * @param isArchive is file archive 
     */
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}
	
	 /**
     * Get the isHidden of the file 
     * @return isHidden is file Hidden 
     */
	public boolean isHidden() {
		return isHidden;
	}
	
	 /**
     * Set the isHidden of the file 
     * @param isHidden flag is file Hidden 
     */
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	 
	/**
     * Set the isOther of the file 
     *  @param isOther is file other
     */
	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}
	
	/**
     * Get the name of a file
     * @return name of a file
     */
	public String getName() {
		return this.name;
	}
	
	/**
     * Set the name of the file 
     *  @param name of the file 
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Get the list of the owner permission of a file
     * @return list of the owner permission of a file
     */
	public List getOwnerPermission() {
		return ownerPermission;
	}

	
	/**
     * Set the list of the owner permission of a file
     * @param ownerPermission list of the owner permission of a file
     */
	public void setOwnerPermission(List ownerPermission) {
		this.ownerPermission = ownerPermission;
	}
	
	/**
     * Get the list of the group permission of a file
     * @return list of the group permission of a file
     */
	public List getGroupPermission() {
		return groupPermission;
	}

	/**
     * Set the list of the group permission of a file
     * @param groupPermission list of the group permission of a file
     */
	public void setGroupPermission(List groupPermission) {
		this.groupPermission = groupPermission;
	}
	
	/**
     * Get the list of the everyone permission of a file
     * @return AllPermission list of the everyone permission of a file
     */
	public List getAllPermission() {
		return AllPermission;
	}

	/**
     * Set the list of the everyone permission of a file
     * @param allPermission list of the everyone permission of a file
     */
	public void setAllPermission(List allPermission) {
		AllPermission = allPermission;
	}
}
