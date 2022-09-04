package com.cybage.food.EntityDTOConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cybage.food.dto.CartResponseDTO;
import com.cybage.food.entity.Cart;
import com.cybage.food.entity.FoodItem;

@Component
public class CartMapper {
	public CartResponseDTO toCartResponseDto(Cart cart) {
		CartResponseDTO cartResponseDto = new CartResponseDTO();
		cartResponseDto.setCartId(cart.getCartId());
		List<String> foodNameList= new ArrayList<>();
		for(FoodItem foodItem : cart.getFoodItem()) {
			String foodName = foodItem.getFoodName();
			foodNameList.add(foodName);
		}
		cartResponseDto.setFoodName(foodNameList);
		return cartResponseDto;
	}
}
