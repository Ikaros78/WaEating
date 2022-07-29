package com.waeating.review.model.dto;

import java.sql.Date;

public class ReviewAttachDTO {
	
	private int fileNo;
	private int reviewNo;
	private String originName;
	private String fileName;
	private String isDeleted;
	private java.sql.Date regDate;
	
	public ReviewAttachDTO() {}

	public ReviewAttachDTO(int fileNo, int reviewNo, String originName, String fileName, String isDeleted,
			Date regDate) {
		super();
		this.fileNo = fileNo;
		this.reviewNo = reviewNo;
		this.originName = originName;
		this.fileName = fileName;
		this.isDeleted = isDeleted;
		this.regDate = regDate;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	@Override
	public String toString() {
		return "ReviewAttachDTO [fileNo=" + fileNo + ", reviewNo=" + reviewNo + ", originName=" + originName
				+ ", fileName=" + fileName + ", isDeleted=" + isDeleted + ", regDate=" + regDate + "]";
	}
	
	
	
	

}
