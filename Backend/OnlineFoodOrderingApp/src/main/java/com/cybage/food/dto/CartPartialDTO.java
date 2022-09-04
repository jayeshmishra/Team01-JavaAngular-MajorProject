package com.cybage.food.dto;

import com.cybage.food.entity.FoodItem;

public class CartPartialDTO {
	private FoodItem foodItem;
	private int quantity;

	public CartPartialDTO() {
		super();
	}

	public CartPartialDTO(FoodItem foodItem, int quantity) {
		super();
		this.foodItem = foodItem;
		this.quantity = quantity;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartPartialDTO [foodItem=" + foodItem + ", quantity=" + quantity + "]";
	}

}
