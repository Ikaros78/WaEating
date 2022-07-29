package com.waeating.support.model.dto;

import java.sql.Date;

public class ReportAnswerDTO {
	
	private int ansNo;
	private String ansContent;
	private java.sql.Date ansDate;
	private String isDeleted;
	private int reportNo;
	
	public ReportAnswerDTO() {}

	public ReportAnswerDTO(int ansNo, String ansContent, Date ansDate, String isDeleted, int reportNo) {
		super();
		this.ansNo = ansNo;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.isDeleted = isDeleted;
		this.reportNo = reportNo;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public java.sql.Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(java.sql.Date ansDate) {
		this.ansDate = ansDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	@Override
	public String toString() {
		return "ReportAnswerDTO [ansNo=" + ansNo + ", ansContent=" + ansContent + ", ansDate=" + ansDate
				+ ", isDeleted=" + isDeleted + ", reportNo=" + reportNo + "]";
	}
	
	
	
}
