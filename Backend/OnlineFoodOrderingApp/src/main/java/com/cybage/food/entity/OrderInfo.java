package com.cybage.food.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_info")
public class OrderInfo {
	@Id
	@GeneratedValue
	private int serialNo;
	@ManyToOne
	@JoinColumn(name = "food_id")
	private FoodItem foodItems;
	private int foodRating;
	private String feedback;
	private int quantity;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id")
	private UserOrder userOrder;

	public OrderInfo() {
		super();
	}

	public OrderInfo(int serialNo, FoodItem foodItems, int foodRating, String feedback, int quantity,
			UserOrder userOrder) {
		super();
		this.serialNo = serialNo;
		this.foodItems = foodItems;
		this.foodRating = foodRating;
		this.feedback = feedback;
		this.quantity = quantity;
		this.userOrder = userOrder;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public FoodItem getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(FoodItem foodItems) {
		this.foodItems = foodItems;
	}

	public int getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(int foodRating) {
		this.foodRating = foodRating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Override
	public String toString() {
		return "OrderInfo [serialNo=" + serialNo + ", foodItems=" + foodItems + ", foodRating=" + foodRating
				+ ", feedback=" + feedback + ", quantity=" + quantity + ", userOrder=" + userOrder + "]";
	}

}
