package com.cybage.food.dto;

public class UserAddressDTO {
	private int userId;
	private String userName;
	private String userEmail;
	private String userMobileNo;
	private int addressId;
	private String area;
	private String street;
	private String pincode;

	public UserAddressDTO() {
		super();
	}

	public UserAddressDTO(int userId, String userName, String userEmail, String userMobileNo, int addressId,
			String area, String street, String pincode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNo = userMobileNo;
		this.addressId = addressId;
		this.area = area;
		this.street = street;
		this.pincode = pincode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserAddressDTO [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userMobileNo=" + userMobileNo + ", addressId=" + addressId + ", area=" + area + ", street="
				+ street + ", pincode=" + pincode + "]";
	}

}
