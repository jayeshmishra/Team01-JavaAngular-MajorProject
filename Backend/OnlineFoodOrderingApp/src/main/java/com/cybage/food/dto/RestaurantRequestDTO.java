package com.cybage.food.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestaurantRequestDTO {
	private int restaurantId;
	private String restaurantName;
	private String restaurantUserName;
	private String restaurantPassword;
	private String restaurantEmail;
	@JsonIgnore
	private MultipartFile thumbnail;
	private int attemptCount;
	private String distance;
	private String area;
	private String street;
	private String pincode;

	public RestaurantRequestDTO() {

	}

	public RestaurantRequestDTO(int restaurantId, String restaurantName, String restaurantUserName,
			String restaurantPassword, String restaurantEmail, MultipartFile thumbnail, int attemptCount,
			String distance, String area, String street, String pincode) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUserName = restaurantUserName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.thumbnail = thumbnail;
		this.attemptCount = attemptCount;
		this.distance = distance;
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

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public MultipartFile getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getAttemptCount() {
		return attemptCount;
	}

	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
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
		return "RestaurantRequestDTO [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantUserName=" + restaurantUserName + ", restaurantPassword=" + restaurantPassword
				+ ", restaurantEmail=" + restaurantEmail + ", thumbnail=" + thumbnail + ", attemptCount=" + attemptCount
				+ ", distance=" + distance + ", area=" + area + ", street=" + street + ", pincode=" + pincode + "]";
	}

}
