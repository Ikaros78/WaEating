package com.waeating.reservation.model.dto;

import java.sql.Date;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.member.model.dto.MemberDTO;

public class WaitingRecordDTO {

	private int recordNo;
	private int comNo;
	private String memberId;
	private java.sql.Date useDate;
	private String useStatus;
	private int waitingNo;
	private int memberNum;
	private String requirement;
	private String memo;
	
	private ComInfoDTO comInfo;
	private MemberDTO memberInfo;
	
	public WaitingRecordDTO() {}

	public WaitingRecordDTO(int recordNo, int comNo, String memberId, Date useDate, String useStatus, int waitingNo,
			int memberNum, String requirement, String memo, ComInfoDTO comInfo, MemberDTO memberInfo) {
		super();
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.memberId = memberId;
		this.useDate = useDate;
		this.useStatus = useStatus;
		this.waitingNo = waitingNo;
		this.memberNum = memberNum;
		this.requirement = requirement;
		this.memo = memo;
		this.comInfo = comInfo;
		this.memberInfo = memberInfo;
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

	public int getWaitingNo() {
		return waitingNo;
	}

	public void setWaitingNo(int waitingNo) {
		this.waitingNo = waitingNo;
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

	@Override
	public String toString() {
		return "WaitingRecordDTO [recordNo=" + recordNo + ", comNo=" + comNo + ", memberId=" + memberId + ", useDate="
				+ useDate + ", useStatus=" + useStatus + ", waitingNo=" + waitingNo + ", memberNum=" + memberNum
				+ ", requirement=" + requirement + ", memo=" + memo + ", comInfo=" + comInfo + ", memberInfo="
				+ memberInfo + "]";
	}

	

	
	
}
