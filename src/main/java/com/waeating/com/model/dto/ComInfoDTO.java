package com.waeating.com.model.dto;

import java.util.List;

import com.waeating.member.model.dto.MemberDTO;

public class ComInfoDTO {

	private int comNo;
	private String memberId;
	private String comName;
	private String category;
	private String comAddress;
	private String comPhone;
	private String comRegist;
	private String waitYn;
	private String workTime;
	private String holiday;
	
	private ComBoardAttachDTO comBoardAttach;
	private ComMenuDTO comMenu;
	private MemberDTO memberInfo;
	private List<ComRecordDTO> recordList;
	private ReviewDTO review;
	private WaitingRecordDTO waitingRecord;
	
	
	public ComInfoDTO() {}


	public ComInfoDTO(int comNo, String memberId, String comName, String category, String comAddress, String comPhone,
			String comRegist, String waitYn, String workTime, String holiday, ComBoardAttachDTO comBoardAttach,
			ComMenuDTO comMenu, MemberDTO memberInfo, List<ComRecordDTO> recordList, ReviewDTO review,
			WaitingRecordDTO waitingRecord) {
		super();
		this.comNo = comNo;
		this.memberId = memberId;
		this.comName = comName;
		this.category = category;
		this.comAddress = comAddress;
		this.comPhone = comPhone;
		this.comRegist = comRegist;
		this.waitYn = waitYn;
		this.workTime = workTime;
		this.holiday = holiday;
		this.comBoardAttach = comBoardAttach;
		this.comMenu = comMenu;
		this.memberInfo = memberInfo;
		this.recordList = recordList;
		this.review = review;
		this.waitingRecord = waitingRecord;
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


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getComAddress() {
		return comAddress;
	}


	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}


	public String getComPhone() {
		return comPhone;
	}


	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}


	public String getComRegist() {
		return comRegist;
	}


	public void setComRegist(String comRegist) {
		this.comRegist = comRegist;
	}


	public String getWaitYn() {
		return waitYn;
	}


	public void setWaitYn(String waitYn) {
		this.waitYn = waitYn;
	}


	public String getWorkTime() {
		return workTime;
	}


	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}


	public String getHoliday() {
		return holiday;
	}


	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}


	public ComBoardAttachDTO getComBoardAttach() {
		return comBoardAttach;
	}


	public void setComBoardAttach(ComBoardAttachDTO comBoardAttach) {
		this.comBoardAttach = comBoardAttach;
	}


	public ComMenuDTO getComMenu() {
		return comMenu;
	}


	public void setComMenu(ComMenuDTO comMenu) {
		this.comMenu = comMenu;
	}


	public MemberDTO getMemberInfo() {
		return memberInfo;
	}


	public void setMemberInfo(MemberDTO memberInfo) {
		this.memberInfo = memberInfo;
	}



	public List<ComRecordDTO> getRecordList() {
		return recordList;
	}



	public void setRecordList(List<ComRecordDTO> recordList) {
		this.recordList = recordList;
	}

	
	public ReviewDTO getReview() {
		return review;
	}

	public void setReview(ReviewDTO review) {
		this.review = review;
	}
	



	public WaitingRecordDTO getWaitingRecord() {
		return waitingRecord;
	}


	public void setWaitingRecord(WaitingRecordDTO waitingRecord) {
		this.waitingRecord = waitingRecord;
	}


	@Override
	public String toString() {
		return "ComInfoDTO [comNo=" + comNo + ", memberId=" + memberId + ", comName=" + comName + ", category="
				+ category + ", comAddress=" + comAddress + ", comPhone=" + comPhone + ", comRegist=" + comRegist
				+ ", waitYn=" + waitYn + ", workTime=" + workTime + ", holiday=" + holiday + ", comBoardAttach="
				+ comBoardAttach + ", comMenu=" + comMenu + ", memberInfo=" + memberInfo + ", recordList=" + recordList
				+ ", review=" + review + ", waitingRecord=" + waitingRecord + "]";
	}

}
