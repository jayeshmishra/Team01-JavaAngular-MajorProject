package com.cybage.food.dto;

import java.util.List;

public class OrderDetailsDTO {
	private List<Integer> foodId;
	private int userId;
	private int restaurantId;
	private double total;

	public OrderDetailsDTO() {
		super();
	}

	public OrderDetailsDTO(List<Integer> foodId, int userId, int restaurantId, double total) {
		super();
		this.foodId = foodId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.total = total;
	}

	public List<Integer> getFoodId() {
		return foodId;
	}

	public void setFoodId(List<Integer> foodId) {
		this.foodId = foodId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [foodId=" + foodId + ", userId=" + userId + ", restaurantId=" + restaurantId
				+ ", total=" + total + "]";
	}

}
