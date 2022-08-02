package com.waeating.report.model.dto;

public class ReportDTO {
	
	private int reportNo;
	private String title;
	private String content;
	private String id;
	private java.sql.Date regDate;
	public ReportDTO() {
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.sql.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CsDTO [reportNo=" + reportNo + ", title=" + title + ", content=" + content + ", id=" + id + ", regDate="
				+ regDate + "]";
	} 
	
	
	

}
