package com.cybage.food.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@ManyToMany(mappedBy = "carts")
	private List<FoodItem> foodItems;
	private int quantity;
	private double totalAmount;
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	public Cart() {
		super();
	}

	public Cart(int cartId, List<FoodItem> foodItems, int quantity, double totalAmount, User user) {
		super();
		this.cartId = cartId;
		this.foodItems= foodItems;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.user = user;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<FoodItem> getFoodItem() {
		return foodItems;
	}

	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItems = foodItem;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodItem=" + foodItems + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + ", user=" + user + "]";
	}

}
