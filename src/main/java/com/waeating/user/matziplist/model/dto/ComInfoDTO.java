package com.waeating.user.matziplist.model.dto;

public class ComInfoDTO {
	
	private int comNo;
	private String memberId;
	private String comName;
	private String category;
	private String comAdress;
	private String comPhone;
	private String comRegist;
	private String waitYn;
	private String workTime;
	private String holiday;
	private ComBoardAttachDTO comBoardAttach;
	private ComMenuDTO comMenu;
	
	public ComInfoDTO() {}

	public ComInfoDTO(int comNo, String memberId, String comName, String category, String comAdress, String comPhone,
			String comRegist, String waitYn, String workTime, String holiday, ComBoardAttachDTO comBoardAttach,
			ComMenuDTO comMenu) {
		this.comNo = comNo;
		this.memberId = memberId;
		this.comName = comName;
		this.category = category;
		this.comAdress = comAdress;
		this.comPhone = comPhone;
		this.comRegist = comRegist;
		this.waitYn = waitYn;
		this.workTime = workTime;
		this.holiday = holiday;
		this.comBoardAttach = comBoardAttach;
		this.comMenu = comMenu;
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

	public String getComAdress() {
		return comAdress;
	}

	public void setComAdress(String comAdress) {
		this.comAdress = comAdress;
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

	@Override
	public String toString() {
		return "ComInfoDTO [comNo=" + comNo + ", memberId=" + memberId + ", comName=" + comName + ", category="
				+ category + ", comAdress=" + comAdress + ", comPhone=" + comPhone + ", comRegist=" + comRegist
				+ ", waitYn=" + waitYn + ", workTime=" + workTime + ", holiday=" + holiday + ", comBoardAttach="
				+ comBoardAttach + ", comMenu=" + comMenu + "]";
	}
	
	
	
	

	
	
}
