package com.cybage.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.RestaurantRepository;
import com.cybage.food.dao.UserRepository;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;

@Service
public class AdminService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public User unblockUser(int userId) {
		User user = userRepository.findByUserId(userId);
		user.setAttemptCount(0);
		return userRepository.save(user);
	}
	
	public Restaurant unblockRestaurant(int restaurantId) {
		Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
		restaurant.setAttemptCount(0);
		return restaurantRepository.save(restaurant);
	}
}
