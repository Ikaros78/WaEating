package com.waeating.member.model.dto;

public class UserDTO {

	private String birth;
	private String gender;
	private String userId;
	
	public UserDTO() {}

	public UserDTO(String birth, String gender, String userId) {
		super();
		this.birth = birth;
		this.gender = gender;
		this.userId = userId;
	}


	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDTO [birth=" + birth + ", gender=" + gender + ", userId=" + userId + "]";
	}


	
}
