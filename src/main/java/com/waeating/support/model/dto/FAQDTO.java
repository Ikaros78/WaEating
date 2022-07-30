package com.waeating.support.model.dto;

import java.sql.Date;

public class FAQDTO {

	private int faqNo;
	private String title;
	private String content;
	private java.sql.Date regDate;
	private String id;
	
	public FAQDTO() {}

	public FAQDTO(int faqNo, String title, String content, Date regDate, String id) {
		super();
		this.faqNo = faqNo;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.id = id;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
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

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FAQDTO [faqNo=" + faqNo + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", id="
				+ id + "]";
	}
	
	
}
