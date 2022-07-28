package com.waeating.ceo.notice.model.dto;

import java.sql.Date;

public class ComNoticeAttachDTO {

	private int fileNo;
	private int noticeNo;
	private String originName;
	private String fileName;
	private String isDeleted;
	private java.sql.Date date;
	
	public ComNoticeAttachDTO() {}

	public ComNoticeAttachDTO(int fileNo, int noticeNo, String originName, String fileName, String isDeleted, Date date) {
		this.fileNo = fileNo;
		this.noticeNo = noticeNo;
		this.originName = originName;
		this.fileName = fileName;
		this.isDeleted = isDeleted;
		this.date = date;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ComNoticeAttach [fileNo=" + fileNo + ", noticeNo=" + noticeNo + ", originName=" + originName
				+ ", fileName=" + fileName + ", isDeleted=" + isDeleted + ", date=" + date + "]";
	}
	
}
