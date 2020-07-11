package com.example.filesystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by ajaysahu on 07/07/2020.
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
	
	 
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String string) {
		this.creationTime = string;
	}
	public String getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(String string) {
		this.lastAccessTime = string;
	}
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public boolean getIsDirectory() {
		return isDirectory;
	}
	public void setIsDirectory(boolean b) {
		this.isDirectory = b;
	}
	public boolean getIsOther() {
		return isOther;
	}
	public void setIsOther(boolean b) {
		this.isOther = b;
	}
	public boolean getIsRegularFile() {
		return isRegularFile;
	}
	public void setIsRegularFile(boolean isRegularFile) {
		this.isRegularFile = isRegularFile;
	}
	public boolean getIsSymbolicLink() {
		return isSymbolicLink;
	}
	public void setIsSymbolicLink(boolean b) {
		this.isSymbolicLink = b;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long l) {
		this.size = l;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getTotalSpace() {
		return totalSpace;
	}
	public void setTotalSpace(long totalSpace) {
		this.totalSpace = totalSpace;
	}
	public long getUsedSpace() {
		return usedSpace;
	}
	public void setUsedSpace(long usedSpace) {
		this.usedSpace = usedSpace;
	}
	public long getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(long availableSpace) {
		this.availableSpace = availableSpace;
	}
	public boolean isArchive() {
		return isArchive;
	}
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getOwnerPermission() {
		return ownerPermission;
	}

	public void setOwnerPermission(List ownerPermission) {
		this.ownerPermission = ownerPermission;
	}

	public List getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(List groupPermission) {
		this.groupPermission = groupPermission;
	}

	public List getAllPermission() {
		return AllPermission;
	}

	public void setAllPermission(List allPermission) {
		AllPermission = allPermission;
	}
}
