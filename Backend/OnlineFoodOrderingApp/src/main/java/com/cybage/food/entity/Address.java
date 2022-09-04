package com.cybage.food.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String area;
	private String street;
	private String pincode;
	@OneToOne(mappedBy = "address")
	@JsonBackReference
	private User user;
	@OneToOne(mappedBy = "address")
	@JsonBackReference
	private Restaurant restaurant;

	public Address() {
		super();
	}

	public Address(int addressId, String area, String street, String pincode, User user, Restaurant restaurant) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.street = street;
		this.pincode = pincode;
		this.user = user;
		this.restaurant = restaurant;
	}

	public Address(String area2, String street2, String pincode2) {
		this.area=area2;
		this.street=street2;
		this.pincode=pincode2;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", street=" + street + ", pincode=" + pincode
				+ ", restaurant=" + restaurant + "]";
	}

}
