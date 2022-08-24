package com.cybage.food.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_order")
public class UserOrder {
	@Id
	@GeneratedValue
	private int orderId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String orderStatus;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	private double totalAmount;
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	private LocalDateTime orderTime;
	@JsonIgnore
	@OneToMany(mappedBy = "userOrder")
	private List<OrderInfo> orderInfo;
	@JsonIgnore
	@OneToOne(mappedBy = "userOrder")
	private Complaint complaintInfo;

	public UserOrder() {
		super();
	}

	public UserOrder(int orderId, User user, String orderStatus, Restaurant restaurant, double totalAmount,
			LocalDateTime orderTime, List<OrderInfo> orderInfo, Complaint complaintInfo) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderStatus = orderStatus;
		this.restaurant = restaurant;
		this.totalAmount = totalAmount;
		this.orderTime = orderTime;
		this.orderInfo = orderInfo;
		this.complaintInfo = complaintInfo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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

	public List<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Complaint getComplaintInfo() {
		return complaintInfo;
	}

	public void setComplaintInfo(Complaint complaintInfo) {
		this.complaintInfo = complaintInfo;
	}

	@Override
	public String toString() {
		return "UserOrder [orderId=" + orderId + ", user=" + user + ", orderStatus=" + orderStatus + ", restaurant="
				+ restaurant + ", totalAmount=" + totalAmount + ", orderTime=" + orderTime + ", orderInfo=" + orderInfo
				+ ", complaintInfo=" + complaintInfo + "]";
	}

}
