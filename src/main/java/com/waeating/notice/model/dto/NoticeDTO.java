package com.waeating.notice.model.dto;

import java.sql.Date;

import com.waeating.member.model.dto.MemberDTO;

public class NoticeDTO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private java.sql.Date regDate;
	private String memberId;
	
	
	public NoticeDTO() {}
	
	public NoticeDTO(int noticeNo, String noticetitle, String noticeContent,Date regDate, String memberId) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticetitle;
		this.noticeContent = noticeContent;
		this.regDate= regDate;
		this.memberId= memberId;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", regDate=" + regDate + ", memberId=" + memberId + "]";
	}
	



}
