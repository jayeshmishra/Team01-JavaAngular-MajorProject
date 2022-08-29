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
	private int foodRating;
	private String feedback;
	private int quantity;

	public OrderInfo() {
		super();
	}

	public OrderInfo(int serialNo, int foodRating, String feedback, int quantity) {
		super();
		this.serialNo = serialNo;
		this.foodRating = foodRating;
		this.feedback = feedback;
		this.quantity = quantity;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
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

	@Override
	public String toString() {
		return "OrderInfo [serialNo=" + serialNo + ", foodRating=" + foodRating + ", feedback=" + feedback
				+ ", quantity=" + quantity + "]";
	}

}
