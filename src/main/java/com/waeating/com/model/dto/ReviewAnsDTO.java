package com.waeating.com.model.dto;

import java.sql.Date;

public class ReviewAnsDTO {

	private int ansNo;
	private String ansContent;
	private java.sql.Date regDate;
	private int reviewNo;
	
	public ReviewAnsDTO() {}

	public ReviewAnsDTO(int ansNo, String ansContent, Date regDate, int reviewNo) {
		this.ansNo = ansNo;
		this.ansContent = ansContent;
		this.regDate = regDate;
		this.reviewNo = reviewNo;
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

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	@Override
	public String toString() {
		return "ReviewAnsDTO [ansNo=" + ansNo + ", ansContent=" + ansContent + ", regDate=" + regDate + ", reviewNo="
				+ reviewNo + "]";
	}

}
