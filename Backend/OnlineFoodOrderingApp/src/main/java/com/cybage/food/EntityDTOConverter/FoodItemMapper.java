package com.cybage.food.EntityDTOConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cybage.food.dto.FoodItemDetailsDTO;
import com.cybage.food.dto.FoodItemRequestDTO;
import com.cybage.food.dto.FoodItemResponseDTO;
import com.cybage.food.entity.FoodItem;

@Component
public class FoodItemMapper {
	public  FoodItem toFoodItemEntity(FoodItemRequestDTO foodItemRequestDto) {
		FoodItem entity = new FoodItem();
		BeanUtils.copyProperties(foodItemRequestDto, entity, "thumbnail");
		return entity;
	}
	
	public  FoodItemResponseDTO toFoodItemResponseDto(FoodItem foodItem) {
		FoodItemResponseDTO foodItemResponseDTO = new FoodItemResponseDTO();
		BeanUtils.copyProperties(foodItem,foodItemResponseDTO);
		foodItemResponseDTO.setRestaurantId(foodItem.getRestaurant().getRestaurantId());
		foodItemResponseDTO.setRestaurantUserName(foodItem.getRestaurant().getRestaurantUserName());
		foodItemResponseDTO.setRestaurantEmail(foodItem.getRestaurant().getRestaurantEmail());
		foodItemResponseDTO.setRestaurantName(foodItem.getRestaurant().getRestaurantName());
		foodItemResponseDTO.setRestaurantPassword(foodItem.getRestaurant().getRestaurantPassword());
		foodItemResponseDTO.setAttemptCount(foodItem.getRestaurant().getAttemptCount());
		return foodItemResponseDTO;
	}
	
	public FoodItem toFoodItemEntity(FoodItem foodItem) {
		FoodItem foodItem1 = new FoodItem();
		BeanUtils.copyProperties(foodItem,foodItem1);
		return foodItem1;
	}
	
	public List<FoodItemDetailsDTO> toFoodItemDetailsDto(List<FoodItem> foodItemList) {
		List<FoodItemDetailsDTO> foodItemDetailsDtoList = new ArrayList<>();
		
		
		for(FoodItem foodItem : foodItemList) {
			foodItemDetailsDtoList.add(toFoodItemDetailsDto(foodItem));
		}
		System.out.println(foodItemDetailsDtoList);
		return foodItemDetailsDtoList;
	}
	
	public FoodItemDetailsDTO toFoodItemDetailsDto(FoodItem foodItem) {
		FoodItemDetailsDTO foodItemDetailsDto = new FoodItemDetailsDTO();
		foodItemDetailsDto.setFoodId(foodItem.getFoodId());
		foodItemDetailsDto.setFoodName(foodItem.getFoodName());
		foodItemDetailsDto.setFoodCategory(foodItem.getFoodCategory());
		foodItemDetailsDto.setFoodDescription(foodItem.getFoodDescription());
		foodItemDetailsDto.setPrice(foodItem.getPrice());
		foodItemDetailsDto.setOffer(foodItem.getOffer());
		foodItemDetailsDto.setThumbnail(foodItem.getThumbnail());
		return foodItemDetailsDto;
	}
}
