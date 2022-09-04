package com.cybage.food.dto;

public class RestaurantLoginDTO {
	private String restaurantPassword;
	private String restaurantEmail;

	public RestaurantLoginDTO() {
		super();
	}

	public RestaurantLoginDTO(String restaurantPassword, String restaurantEmail) {
		super();
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
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

	@Override
	public String toString() {
		return "RestaurantLoginDTO [restaurantPassword=" + restaurantPassword + ", restaurantEmail=" + restaurantEmail
				+ "]";
	}

}
