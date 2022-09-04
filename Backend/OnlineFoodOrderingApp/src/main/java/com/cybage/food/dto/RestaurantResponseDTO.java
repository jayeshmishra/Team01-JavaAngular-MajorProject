package com.cybage.food.dto;

public class RestaurantResponseDTO {
	private int restaurantId;
	private String restaurantName;
	private String restaurantUserName;
	private String restaurantEmail;
	private String thumbnail;
	private String distance;
	private int addressId;
	private String area;
	private String street;
	private String pincode;

	public RestaurantResponseDTO() {

	}

	public RestaurantResponseDTO(int restaurantId, String restaurantName, String restaurantUserName,
			String restaurantEmail, String thumbnail, String distance, int addressId, String area, String street,
			String pincode) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUserName = restaurantUserName;
		this.restaurantEmail = restaurantEmail;
		this.thumbnail = thumbnail;
		this.distance = distance;
		this.addressId = addressId;
		this.area = area;
		this.street = street;
		this.pincode = pincode;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantUserName() {
		return restaurantUserName;
	}

	public void setRestaurantUserName(String restaurantUserName) {
		this.restaurantUserName = restaurantUserName;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
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
		return "RestaurantResponseDTO [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantUserName=" + restaurantUserName + ", restaurantEmail=" + restaurantEmail + ", thumbnail="
				+ thumbnail + ", distance=" + distance + ", addressId=" + addressId + ", area=" + area + ", street="
				+ street + ", pincode=" + pincode + "]";
	}

}
