package com.waeating.com.model.dto;

import java.sql.Date;

public class ComBoardAttachDTO {
	
	private int fileNo;
	private String originName;
	private String fileName;
	private String thumbnailName;
	private String isDeleted;
	private java.sql.Date regDate;
	private int comNo;
	
	public ComBoardAttachDTO() {}

	public ComBoardAttachDTO(int fileNo, String originName, String fileName, String thumbnailName, String isDeleted,
			Date regDate, int comNo) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.fileName = fileName;
		this.thumbnailName = thumbnailName;
		this.isDeleted = isDeleted;
		this.regDate = regDate;
		this.comNo = comNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	@Override
	public String toString() {
		return "ComBoardAttachDTO [fileNo=" + fileNo + ", originName=" + originName + ", fileName=" + fileName
				+ ", thumbnailName=" + thumbnailName + ", isDeleted=" + isDeleted + ", regDate=" + regDate + ", comNo="
				+ comNo + "]";
	}
	

}
