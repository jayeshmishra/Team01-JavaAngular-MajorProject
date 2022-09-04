package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.Address;
import com.cybage.food.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	public List<Restaurant> findByAddress(Address address);
	public Restaurant findByRestaurantEmailAndRestaurantPassword(String email, String password);
	public Restaurant findByRestaurantEmail(String email);
	public Restaurant findByRestaurantId(int restaurantId);
}
