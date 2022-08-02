package com.waeating.member.model.dto;

public class WishlistDTO {

	private String memberId;
	private int comNo;
	
	public WishlistDTO() {}

	public WishlistDTO(String memberId, int comNo) {
		this.memberId = memberId;
		this.comNo = comNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	@Override
	public String toString() {
		return "WishlistDTO [memberId=" + memberId + ", comNo=" + comNo + "]";
	}
	
	
}
