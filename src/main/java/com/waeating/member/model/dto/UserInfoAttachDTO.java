package com.waeating.member.model.dto;

import java.sql.Date;

public class UserInfoAttachDTO {

	private int fileNo;
	private String memberId;
	private String originName;
	private String fileName;
	private String isDeleted;
	private java.sql.Date regDate;
	
	public UserInfoAttachDTO() {}

	public UserInfoAttachDTO(int fileNo, String memberId, String originName, String fileName, String isDeleted,
			Date regDate) {
		super();
		this.fileNo = fileNo;
		this.memberId = memberId;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "UserInfoAttach [fileNo=" + fileNo + ", memberId=" + memberId + ", originName=" + originName
				+ ", fileName=" + fileName + ", isDeleted=" + isDeleted + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
}
