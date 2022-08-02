package com.waeating.com.model.dto;

public class ReviewDTO {

	private int reviewNo;
	private String reviewContent;
	private int ratings;
	private int recordNo;
	private int comNo;
	private int total;
	
	private ReviewAnsDTO reviewAns;
	private WaitingRecordDTO waitingRecord;
	
	public ReviewDTO() {}

	public ReviewDTO(int reviewNo, String reviewContent, int ratings, int recordNo, int comNo, int total,
			ReviewAnsDTO reviewAns, WaitingRecordDTO waitingRecord) {
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.ratings = ratings;
		this.recordNo = recordNo;
		this.comNo = comNo;
		this.total = total;
		this.reviewAns = reviewAns;
		this.waitingRecord = waitingRecord;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ReviewAnsDTO getReviewAns() {
		return reviewAns;
	}

	public void setReviewAns(ReviewAnsDTO reviewAns) {
		this.reviewAns = reviewAns;
	}

	public WaitingRecordDTO getWaitingRecord() {
		return waitingRecord;
	}

	public void setWaitingRecord(WaitingRecordDTO waitingRecord) {
		this.waitingRecord = waitingRecord;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", ratings=" + ratings
				+ ", recordNo=" + recordNo + ", comNo=" + comNo + ", total=" + total + ", reviewAns=" + reviewAns
				+ ", waitingRecord=" + waitingRecord + "]";
	}
	
}
