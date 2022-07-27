package com.waeating.ceo.restInfo.model.dto;

public class ComMenuDTO {

	private int menuNo;
	private String menuName;
	private int price;
	private int comNo;
	
	public ComMenuDTO() {}

	public ComMenuDTO(int menuNo, String menuName, int price, int comNo) {
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.price = price;
		this.comNo = comNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	@Override
	public String toString() {
		return "ComMenuDTO [menuNo=" + menuNo + ", menuName=" + menuName + ", price=" + price + ", comNo=" + comNo
				+ "]";
	}
	
}
