package com.cybage.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.dto.CartDTO;
import com.cybage.food.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addToCart/{userId}/{cartId}")
	public ResponseEntity<?> addFoodItemsToCart(@PathVariable("userId") int userId , @PathVariable("cartId") int cartId, CartDTO cartDto){
		return new ResponseEntity<>(cartService.addFoodItemToCart(userId, cartDto ,cartId) , HttpStatus.OK);
	}
}
