package com.cybage.food.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderHistoryDTO {
	private int orderId;
	private String orderStatus;
	private double totalAmount;
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private LocalDateTime orderTime;
	private int serialNo;
	private List<String> foodName;
	private double price;
	private String restaurantName;

	public OrderHistoryDTO() {
		super();
	}

	public OrderHistoryDTO(int orderId, String orderStatus, double totalAmount, LocalDateTime orderTime, int serialNo,
			List<String> foodName, double price, String restaurantName) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.orderTime = orderTime;
		this.serialNo = serialNo;
		this.foodName = foodName;
		this.price = price;
		this.restaurantName = restaurantName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public List<String> getFoodName() {
		return foodName;
	}

	public void setFoodName(List<String> foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Override
	public String toString() {
		return "OrderHistoryDTO [orderId=" + orderId + ", orderStatus=" + orderStatus + ", totalAmount=" + totalAmount
				+ ", orderTime=" + orderTime + ", serialNo=" + serialNo + ", foodName=" + foodName + ", price=" + price
				+ ", restaurantName=" + restaurantName + "]";
	}

}
