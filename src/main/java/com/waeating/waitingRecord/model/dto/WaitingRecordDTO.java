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
	private String useTime;
	private int rNum;
	
	private ComInfoDTO comInfo;
	private MemberDTO memberInfo;
	private ReviewDTO review;
	private WaitingRefuseDTO refuseReason;
	
	public WaitingRecordDTO() {}

	public WaitingRecordDTO(int recordNo, int comNo, String memberId, Date useDate, String useStatus, int memberNum,
			String requirement, String memo, int countRecordNo, String useTime, int rNum, ComInfoDTO comInfo,
			MemberDTO memberInfo, ReviewDTO review, WaitingRefuseDTO refuseReason) {
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.memberId = memberId;
		this.useDate = useDate;
		this.useStatus = useStatus;
		this.memberNum = memberNum;
		this.requirement = requirement;
		this.memo = memo;
		this.countRecordNo = countRecordNo;
		this.useTime = useTime;
		this.rNum = rNum;
		this.comInfo = comInfo;
		this.memberInfo = memberInfo;
		this.review = review;
		this.refuseReason = refuseReason;
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

	public int getCountRecordNo() {
		return countRecordNo;
	}

	public void setCountRecordNo(int countRecordNo) {
		this.countRecordNo = countRecordNo;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
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

	public WaitingRefuseDTO getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(WaitingRefuseDTO refuseReason) {
		this.refuseReason = refuseReason;
	}

	@Override
	public String toString() {
		return "WaitingRecordDTO [recordNo=" + recordNo + ", comNo=" + comNo + ", memberId=" + memberId + ", useDate="
				+ useDate + ", useStatus=" + useStatus + ", memberNum=" + memberNum + ", requirement=" + requirement
				+ ", memo=" + memo + ", countRecordNo=" + countRecordNo + ", useTime=" + useTime + ", rNum=" + rNum
				+ ", comInfo=" + comInfo + ", memberInfo=" + memberInfo + ", review=" + review + ", refuseReason="
				+ refuseReason + "]";
	}

	
	
}
