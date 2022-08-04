package com.waeating.notice.model.dto;

import java.sql.Date;

public class NoticeAttachDTO {
	
	private int fileNo;
	private int noticeNo;
	private String originName;
	private String fileName;
	private String isDeleted;
	private java.sql.Date regDate;
	
	public NoticeAttachDTO() {}

	public NoticeAttachDTO(int fileNo, int noticeNo, String originName, String fileName, String isDeleted,
			Date regDate) {
		super();
		this.fileNo = fileNo;
		this.noticeNo = noticeNo;
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

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "NoticeAttachDTO [fileNo=" + fileNo + ", noticeNo=" + noticeNo + ", originName=" + originName
				+ ", fileName=" + fileName + ", isDeleted=" + isDeleted + ", regDate=" + regDate + "]";
	}
	
	
}
