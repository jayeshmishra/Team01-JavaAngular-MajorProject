package com.cybage.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;
import com.cybage.food.exception.CustomException;
import com.cybage.food.service.AdminService;
import com.cybage.food.service.ExportService;
import com.cybage.food.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodapp")
public class AdminController {
	
	@Autowired
	ExportService exportService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	
	@PutMapping("/unblock/{userId}")
	public ResponseEntity<?> unblockUser(@PathVariable int userId) throws CustomException {
		User updatedUser = adminService.unblockUser(userId);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}
		throw new CustomException("user not found");
	}
	
	@PutMapping("/unblock/restOwner/{restaurantId}")
	public ResponseEntity<?> unblockRestaurantOwner(@PathVariable int restaurantId) throws CustomException {
		Restaurant updatedRestaurant = adminService.unblockRestaurant(restaurantId);
		if (updatedRestaurant != null) {
			return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
		}
		throw new CustomException("Restaurant not found");
	}

	@GetMapping("/export-user-details")
	public ResponseEntity<?> exportUserDetails() {
		exportService.printUser();
		return new ResponseEntity<>("User details has been exported to excel file", HttpStatus.OK);
	}

	
	@GetMapping("/export-foodItem-details")
	public ResponseEntity<?> exportFoodItemDetails() {
		exportService.printFoodItemData();
		return new ResponseEntity<>("Food Item Details has been exported to excel file", HttpStatus.OK);
	}

	@GetMapping("/export-restaurant-details")
	public ResponseEntity<?> exportRestaurantDetails() {
		exportService.printRestaurantData();
		return new ResponseEntity<>("Restaurant Details has been exported to excel file", HttpStatus.OK);
	}
	
	@GetMapping("/allLockedUser")
	public ResponseEntity<?> allLockedUser(){
		return new ResponseEntity<>(userService.findAllLockedUsers() , HttpStatus.OK);
	}
}
