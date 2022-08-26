package com.cybage.food.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "food_item")
public class FoodItem {
	@Id
	@GeneratedValue
	private int foodId;
	private String foodName;
	private double price;
	private double offer;
	private String foodCategory;
	private String foodDescription;
	private String thumbnail;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@Transient
	private int quantity;
	@JsonIgnore
	@OneToMany(mappedBy = "foodItems")
	private List<OrderInfo> orderInfo;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "FoodItem_Cart", 
        joinColumns = { @JoinColumn(name = "food_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "cart_id") })
	@JsonIgnore
	private List<Cart> carts;

	public FoodItem() {
		super();
	}

	public FoodItem(int foodId, String foodName, double price, double offer, String foodCategory,
			String foodDescription, String thumbnail, Restaurant restaurant, int quantity, List<OrderInfo> orderInfo) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.offer = offer;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.thumbnail = thumbnail;
		this.restaurant = restaurant;
		this.quantity = quantity;
		this.orderInfo = orderInfo;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String toString() {
		return "FoodItem [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", offer=" + offer
				+ ", foodCategory=" + foodCategory + ", foodDescription=" + foodDescription + ", thumbnail=" + thumbnail
				+ ", restaurant=" + restaurant + ", quantity=" + quantity + ", orderInfo=" + orderInfo + "]";
	}

}
