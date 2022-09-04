package com.cybage.food.dto;

public class FoodItemDetailsDTO {
	private int foodId;
	private String foodName;
	private double price;
	private double offer;
	private String foodCategory;
	private String foodDescription;
	private String thumbnail;

	public FoodItemDetailsDTO() {
		super();
	}

	public FoodItemDetailsDTO(int foodId, String foodName, double price, double offer, String foodCategory,
			String foodDescription, String thumbnail) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.offer = offer;
		this.foodCategory = foodCategory;
		this.foodDescription = foodDescription;
		this.thumbnail = thumbnail;
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

	@Override
	public String toString() {
		return "FoodItemDetailsDTO [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", offer="
				+ offer + ", foodCategory=" + foodCategory + ", foodDescription=" + foodDescription + ", thumbnail="
				+ thumbnail + "]";
	}

}
