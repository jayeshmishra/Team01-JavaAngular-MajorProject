package com.cybage.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.EntityDTOConverter.CartMapper;
import com.cybage.food.dao.CartRepository;
import com.cybage.food.dao.FoodItemRepository;
import com.cybage.food.dao.UserRepository;
import com.cybage.food.dto.CartDTO;
import com.cybage.food.entity.Cart;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.User;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FoodItemRepository foodItemRepository;
	
	@Autowired
	CartMapper cartMapper;
	
	public Cart addFoodItemToCart(int userId ,CartDTO cartDto , int cartId) {
		List<FoodItem> foodItemList=new ArrayList<>();
		FoodItem foodItem = foodItemRepository.findByFoodId(cartDto.getFoodId());
		foodItemList.add(foodItem);
		//List<FoodItem> cartFoodItemList = cartRepository.findByCartId(cartId).getFoodItem();
		User user = userRepository.findByUserId(userId);
		Cart cart = new Cart();
		cart.setFoodItem(foodItemList);
		cart.setUser(user);
		cart.setQuantity(1);
		cart.setTotalAmount(cart.getQuantity()*foodItem.getPrice());
		return cartRepository.save(cart);
	}
}
