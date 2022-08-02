package com.waeating.review.model.dto;

import com.waeating.com.model.dto.ComInfoDTO;
import com.waeating.com.model.dto.WaitingRecordDTO;
import com.waeating.member.model.dto.MemberDTO;
import com.waeating.member.model.dto.UserInfoAttachDTO;

public class ReviewDTO {

	private int reviewNo;
	private String reviewContent;
	private int ratings;
	private int recordNo;
	private int comNo;
	
	private double avgRatings;
	
	private ReviewAttachDTO reviewAttach;
	private MemberDTO memberInfo;
	private WaitingRecordDTO waitingRecord;
	private ReviewAnsDTO reviewAns;
	private ComInfoDTO comInfo;
	private UserInfoAttachDTO userInfoAttach;
	
	public ReviewDTO() {}


	public ReviewDTO(int reviewNo, String reviewContent, int ratings, int recordNo, int comNo, double avgRatings,
			ReviewAttachDTO reviewAttach, MemberDTO memberInfo, WaitingRecordDTO waitingRecord, ReviewAnsDTO reviewAns,
			ComInfoDTO comInfo, UserInfoAttachDTO userInfoAttach) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.ratings = ratings;
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.avgRatings = avgRatings;
		this.reviewAttach = reviewAttach;
		this.memberInfo = memberInfo;
		this.waitingRecord = waitingRecord;
		this.reviewAns = reviewAns;
		this.comInfo = comInfo;
		this.userInfoAttach = userInfoAttach;
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
	
	

	public ComInfoDTO getComInfo() {
		return comInfo;
	}

	public void setComInfo(ComInfoDTO comInfo) {
		this.comInfo = comInfo;
	}

	
	public UserInfoAttachDTO getUserInfoAttach() {
		return userInfoAttach;
	}


	public void setUserInfoAttach(UserInfoAttachDTO userInfoAttach) {
		this.userInfoAttach = userInfoAttach;
	}


	public double getAvgRatings() {
		return avgRatings;
	}


	public void setAvgRatings(double avgRatings) {
		this.avgRatings = avgRatings;
	}



	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", ratings=" + ratings
				+ ", recordNo=" + recordNo + ", comNo=" + comNo + ", avgRatings=" + avgRatings + ", reviewAttach="
				+ reviewAttach + ", memberInfo=" + memberInfo + ", waitingRecord=" + waitingRecord + ", reviewAns="
				+ reviewAns + ", comInfo=" + comInfo + ", userInfoAttach=" + userInfoAttach + "]";
	}
	
	


	
	
	
	
}
