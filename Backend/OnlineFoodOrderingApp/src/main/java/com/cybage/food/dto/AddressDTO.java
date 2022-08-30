package com.cybage.food.dto;

public class AddressDTO {
	private int addressId;
	private String area;
	private String street;
	private String pincode;

	public AddressDTO() {
		super();
	}

	public AddressDTO(int addressId, String area, String street, String pincode) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.street = street;
		this.pincode = pincode;
	}

	
	public AddressDTO(String area, String street, String pincode) {
		this.area = area;
		this.street = street;
		this.pincode = pincode;
		
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
		return "UserAddressDTO [addressId=" + addressId + ", area=" + area + ", street=" + street + ", pincode="
				+ pincode + "]";
	}

}
