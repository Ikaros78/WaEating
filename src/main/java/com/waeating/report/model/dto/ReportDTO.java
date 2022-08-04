package com.waeating.report.model.dto;

import java.sql.Date;

public class ReportDTO {

	private int reportNo;
	private String reportTitle;
	private String reportContent;
	private String memberId;
	private java.sql.Date regDate;
	
	public ReportDTO() {}

	public ReportDTO(int reportNo, String reportTitle, String reportContent, String memberId, Date regDate) {
		super();
		this.reportNo = reportNo;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.memberId = memberId;
		this.regDate = regDate;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", reportTitle=" + reportTitle + ", reportContent=" + reportContent
				+ ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}
	
	
	
}
