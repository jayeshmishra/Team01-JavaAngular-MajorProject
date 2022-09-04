package com.cybage.food.dto;

public class CartDTO {
	private int cartId;
	private int foodId;
	private int quantity;
	private double totalAmount;

	public CartDTO() {
		super();
	}

	public CartDTO(int cartId, int foodId, int quantity, double totalAmount) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", foodId=" + foodId + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + "]";
	}

}
