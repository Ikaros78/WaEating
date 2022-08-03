package com.waeating.com.model.dto;

import java.sql.Date;

public class ComNoticeDTO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private java.sql.Date regDate;
	private int comNo;
	private int rNum;
	private ComNoticeAttachDTO comNoticeAttach;
	
	public ComNoticeDTO() {}

	public ComNoticeDTO(int noticeNo, String noticeTitle, String noticeContent, Date regDate, int comNo, int rNum,
			ComNoticeAttachDTO comNoticeAttach) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.regDate = regDate;
		this.comNo = comNo;
		this.rNum = rNum;
		this.comNoticeAttach = comNoticeAttach;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public java.sql.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public ComNoticeAttachDTO getComNoticeAttach() {
		return comNoticeAttach;
	}

	public void setComNoticeAttach(ComNoticeAttachDTO comNoticeAttach) {
		this.comNoticeAttach = comNoticeAttach;
	}

	@Override
	public String toString() {
		return "ComNoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", regDate=" + regDate + ", comNo=" + comNo + ", rNum=" + rNum + ", comNoticeAttach="
				+ comNoticeAttach + "]";
	}

	
}
