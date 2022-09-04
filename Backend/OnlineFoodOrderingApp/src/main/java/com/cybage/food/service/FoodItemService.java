package com.cybage.food.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.food.EntityDTOConverter.FoodItemMapper;
import com.cybage.food.dao.FoodItemRepository;
import com.cybage.food.dto.FoodItemDetailsDTO;
import com.cybage.food.dto.FoodItemRequestDTO;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.Restaurant;

@Service
public class FoodItemService {
	@Autowired
	FoodItemRepository foodItemRepository;

	@Autowired
	FileService fileService;
	
	@Autowired
	FoodItemMapper foodItemMapper;

	public FoodItem addFoodItem(FoodItemRequestDTO foodItemRequestDto,  Restaurant restaurant) throws IOException {
		//String fileName = fileService.save(thumbnail);
		FoodItem foodItem = foodItemMapper.toFoodItemEntity(foodItemRequestDto);
		//foodItem.setThumbnail(fileName);
		foodItem.setRestaurant(restaurant);
		return foodItemRepository.save(foodItem);
	}

	public void deleteFoodItem(int foodId) {
		foodItemRepository.deleteById(foodId);
	}

	public FoodItem findByFoodId(int foodId) {
		return foodItemRepository.findByFoodId(foodId);
	}

	public FoodItem updateFoodItem(FoodItem foodItem, int foodId) {
		return foodItemRepository.save(foodItem);
	}

	public List<FoodItem> findAllFoodItems() {
		return foodItemRepository.findAll();
	}

	public FoodItem findById(int foodId) {
		return foodItemRepository.findById(foodId).get();
	}

	public List<FoodItemDetailsDTO> getByRestaurantId(int restuarantId) {
		
		 return foodItemMapper.toFoodItemDetailsDto(foodItemRepository.findFoodByRestaurantId(restuarantId));
	}
	
	public List<FoodItem> getByRestaurantIdReturnsFoodItemList(int restuarantId) {
		
		 return foodItemRepository.findFoodByRestaurantId(restuarantId);
	}

	public FoodItem updateFoodItem(FoodItemRequestDTO foodItemRequestDto, MultipartFile thumbnail , int foodId) throws IOException {
		FoodItem foodItem = findByFoodId(foodId);
		FoodItem foodItem1 = foodItemMapper.toFoodItemEntity(foodItem);
		foodItem1.setFoodId(foodItem.getFoodId());
		if(thumbnail != null) {
		String fileName = fileService.save(thumbnail);
		foodItem1.setThumbnail(fileName);
		}
		if(foodItemRequestDto.getFoodName() != null) {
			foodItem1.setFoodName(foodItemRequestDto.getFoodName());
			}
		if(foodItemRequestDto.getPrice() != 0.0) {
			foodItem1.setPrice(foodItemRequestDto.getPrice());
			}
		if(foodItemRequestDto.getOffer() != 0.0) {
			foodItem1.setOffer(foodItemRequestDto.getOffer());
			}
		return foodItemRepository.save(foodItem1);
	}

	public FoodItem updateOffer(FoodItem foodItem) {
		return foodItemRepository.save(foodItem);
	}

	public List<FoodItem> findByOfferNot(double offer) {
		return foodItemRepository.findByOfferNot(offer);
	}

	public List<FoodItem> findByOffer(double offer) {
		return foodItemRepository.findByOffer(offer);
	}

}
