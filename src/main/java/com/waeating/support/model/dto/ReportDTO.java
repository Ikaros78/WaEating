package com.waeating.support.model.dto;

public class ReportDTO {

	private int reportNo;
	private String title;
	private String content;
	private String id;
	private String regDate; 
	private ReportAnswerDTO answer;
	
	public ReportDTO() {}

	public ReportDTO(int reportNo, String title, String content, String id) {
		super();
		this.reportNo = reportNo;
		this.title = title;
		this.content = content;
		this.id = id;
	}

	public ReportDTO(int reportNo, String title, String content, String id, String regDate, ReportAnswerDTO answer) {
		super();
		this.reportNo = reportNo;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regDate = regDate;
		this.answer = answer;
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
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public ReportAnswerDTO getAnswer() {
		return answer;
	}

	public void setAnswer(ReportAnswerDTO answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", regDate=" + regDate + ", answer=" + answer + "]";
	}
	
	
 }
