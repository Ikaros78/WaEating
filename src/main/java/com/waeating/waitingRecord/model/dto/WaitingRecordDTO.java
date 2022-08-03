package com.waeating.waitingRecord.model.dto;

import java.sql.Date;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.review.model.dto.ReviewDTO;

public class WaitingRecordDTO {

	private int recordNo;
	private int comNo;
	private String memberId;
	private java.sql.Date useDate;
	private String useStatus;
	private int memberNum;
	private String requirement;
	private String memo;
	private int countRecordNo;
	
	private ComInfoDTO comInfo;
	private MemberDTO memberInfo;
	private ReviewDTO review;
	
	public WaitingRecordDTO() {}

	


	public WaitingRecordDTO(int recordNo, int comNo, String memberId, Date useDate, String useStatus, int memberNum,
			String requirement, String memo, int countRecordNo, ComInfoDTO comInfo, MemberDTO memberInfo,
			ReviewDTO review) {
		super();
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.memberId = memberId;
		this.useDate = useDate;
		this.useStatus = useStatus;
		this.memberNum = memberNum;
		this.requirement = requirement;
		this.memo = memo;
		this.countRecordNo = countRecordNo;
		this.comInfo = comInfo;
		this.memberInfo = memberInfo;
		this.review = review;
	}




	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public java.sql.Date getUseDate() {
		return useDate;
	}

	public void setUseDate(java.sql.Date useDate) {
		this.useDate = useDate;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public ComInfoDTO getComInfo() {
		return comInfo;
	}

	public void setComInfo(ComInfoDTO comInfo) {
		this.comInfo = comInfo;
	}

	public MemberDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

	
	public ReviewDTO getReview() {
		return review;
	}

	public void setReview(ReviewDTO review) {
		this.review = review;
	}
	
	

	public int getCountRecordNo() {
		return countRecordNo;
	}




	public void setCountRecordNo(int countRecordNo) {
		this.countRecordNo = countRecordNo;
	}




	@Override
	public String toString() {
		return "WaitingRecordDTO [recordNo=" + recordNo + ", comNo=" + comNo + ", memberId=" + memberId + ", useDate="
				+ useDate + ", useStatus=" + useStatus + ", memberNum=" + memberNum + ", requirement=" + requirement
				+ ", memo=" + memo + ", countRecordNo=" + countRecordNo + ", comInfo=" + comInfo + ", memberInfo="
				+ memberInfo + ", review=" + review + "]";
	}

	
}
