package com.waeating.member.model.dto;

import java.util.List;

public class MemberDTO {
	private String id;
	private String pwd;
	private String email;
	private String name;
	private String memberType;
	private String phone;
	private String emailCheck;
	private List<UserDTO> userInfo;
	
	public MemberDTO() {}

	public MemberDTO(String id, String pwd, String email, String name, String memberType, String phone,
			String emailCheck) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.phone = phone;
		this.emailCheck = emailCheck;
	}
	
	public MemberDTO(String id, String pwd, String email, String name, String memberType, String phone,
			String emailCheck, List<UserDTO> userInfo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.phone = phone;
		this.emailCheck = emailCheck;
		this.userInfo = userInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public List<UserDTO> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserDTO> userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", memberType="
				+ memberType + ", phone=" + phone + ", emailCheck=" + emailCheck + ", userInfo=" + userInfo + "]";

	}

	
	
	
}
