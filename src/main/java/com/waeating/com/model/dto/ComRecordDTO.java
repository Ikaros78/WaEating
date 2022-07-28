package com.waeating.com.model.dto;

public class ComRecordDTO {
	
	private int recordNo;
	private String reason;
	private int comNo;
	private String status;
	
	public ComRecordDTO() {	}

	public ComRecordDTO(int recordNo, String reason, int comNo, String status) {
		super();
		this.recordNo = recordNo;
		this.reason = reason;
		this.comNo = comNo;
		this.status = status;
	}

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ComRecordDTO [recordNo=" + recordNo + ", reason=" + reason + ", comNo=" + comNo + ", status=" + status
				+ "]";
	}
	
	
	
}
