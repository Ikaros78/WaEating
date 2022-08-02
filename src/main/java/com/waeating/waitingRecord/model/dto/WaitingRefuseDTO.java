package com.waeating.waitingRecord.model.dto;

public class WaitingRefuseDTO {

	private int recordNo;
	private String refuseReason;
	
	
	public WaitingRefuseDTO() {}


	public WaitingRefuseDTO(int recordNo, String refuseReason) {
		this.recordNo = recordNo;
		this.refuseReason = refuseReason;
	}


	public int getRecordNo() {
		return recordNo;
	}


	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}


	public String getRefuseReason() {
		return refuseReason;
	}


	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}


	@Override
	public String toString() {
		return "WaitingRefuseDTO [recordNo=" + recordNo + ", refuseReason=" + refuseReason + "]";
	}
	
	
}
