package com.cybage.food.dto;

import java.util.List;

public class CartResponseDTO {
	private int cartId;
	private List<String> foodName;
	public void setFoodName(List<String> foodName) {
		this.foodName = foodName;
	}

	private int foodQuantity;
	private int totalQuantity;
	private double totalAmount;

	public CartResponseDTO() {
		super();
	}

	public CartResponseDTO(int cartId, String foodName, int foodQuantity, int totalQuantity, double totalAmount) {
		super();
		this.cartId = cartId;
		this.foodQuantity = foodQuantity;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CartResponseDTO [cartId=" + cartId + ", foodName=" + foodName + ", foodQuantity=" + foodQuantity
				+ ", totalQuantity=" + totalQuantity + ", totalAmount=" + totalAmount + "]";
	}

}
