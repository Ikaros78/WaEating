package com.waeating.review.model.dto;

import com.waeating.com.model.dto.WaitingRecordDTO;
import com.waeating.member.model.dto.MemberDTO;

public class ReviewDTO {

	private int reviewNo;
	private String reviewContent;
	private int ratings;
	private int recordNo;
	private int comNo;
	
	private ReviewAttachDTO reviewAttach;
	private MemberDTO memberInfo;
	private WaitingRecordDTO waitingRecord;
	private ReviewAnsDTO reviewAns;
	
	public ReviewDTO() {}

	public ReviewDTO(int reviewNo, String reviewContent, int ratings, int recordNo, int comNo,
			ReviewAttachDTO reviewAttach, MemberDTO memberInfo, WaitingRecordDTO waitingRecord,
			ReviewAnsDTO reviewAns) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.ratings = ratings;
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.reviewAttach = reviewAttach;
		this.memberInfo = memberInfo;
		this.waitingRecord = waitingRecord;
		this.reviewAns = reviewAns;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
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

	public ReviewAttachDTO getReviewAttach() {
		return reviewAttach;
	}

	public void setReviewAttach(ReviewAttachDTO reviewAttach) {
		this.reviewAttach = reviewAttach;
	}

	public MemberDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

	public WaitingRecordDTO getWaitingRecord() {
		return waitingRecord;
	}

	public void setWaitingRecord(WaitingRecordDTO waitingRecord) {
		this.waitingRecord = waitingRecord;
	}

	public ReviewAnsDTO getReviewAns() {
		return reviewAns;
	}

	public void setReviewAns(ReviewAnsDTO reviewAns) {
		this.reviewAns = reviewAns;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", ratings=" + ratings
				+ ", recordNo=" + recordNo + ", comNo=" + comNo + ", reviewAttach=" + reviewAttach + ", memberInfo="
				+ memberInfo + ", waitingRecord=" + waitingRecord + ", reviewAns=" + reviewAns + "]";
	}
	
	


	
	
	
	
}
