package com.cybage.food.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FoodItemRequestDTO {
	private int foodId;
	private String foodName;
	private double price;
	private double offer;
	private String foodCategory;
	private String foodDescription;
	@JsonIgnore
	private MultipartFile thumbnail;
	private int restaurantId;
	private String restaurantName;
	private String restaurantUserName;
	private String restaurantPassword;
	private String restaurantEmail;
	private int attemptCount;

	public FoodItemRequestDTO() {
		super();
	}

	public FoodItemRequestDTO(int foodId, String foodName, double price, double offer, String foodCategory,
			String foodDescription, MultipartFile thumbnail, int restaurantId, String restaurantName,
			String restaurantUserName, String restaurantPassword, String restaurantEmail, int attemptCount) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.offer = offer;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.thumbnail = thumbnail;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUserName = restaurantUserName;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
		this.attemptCount = attemptCount;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public MultipartFile getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
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

	public int getAttemptCount() {
		return attemptCount;
	}

	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}

	@Override
	public String toString() {
		return "FoodItemRequestDTO [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", offer="
				+ offer + ", foodCategory=" + foodCategory + ", foodDescription=" + foodDescription + ", thumbnail="
				+ thumbnail + ", restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantUserName=" + restaurantUserName + ", restaurantPassword=" + restaurantPassword
				+ ", restaurantEmail=" + restaurantEmail + ", attemptCount=" + attemptCount + "]";
	}

}
