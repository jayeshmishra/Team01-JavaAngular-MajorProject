package com.cybage.food.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.EntityDTOConverter.FoodItemMapper;
import com.cybage.food.dto.FoodItemDetailsDTO;
import com.cybage.food.dto.FoodItemRequestDTO;
import com.cybage.food.dto.FoodItemResponseDTO;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.service.FoodItemService;
import com.cybage.food.service.RestaurantService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/fooditem")
public class FoodItemController {
	@Autowired
	FoodItemService foodItemService;

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	FoodItemMapper foodItemMapper;

	@GetMapping("/{foodId}")
	public ResponseEntity<?> addFoodItem(@PathVariable int foodId, FoodItem foodItem) {
		return new ResponseEntity<>(foodItemService.findById(foodId), HttpStatus.ACCEPTED);
	}

	@PostMapping("/addFoodItem")
	public ResponseEntity<?> addFoodItem(@RequestBody FoodItemRequestDTO foodItemRequestDTO) {
		FoodItemResponseDTO newFoodItem = null;
		try {
			newFoodItem = foodItemMapper.toFoodItemResponseDto(
					(foodItemService.addFoodItem(foodItemRequestDTO,
							restaurantService.findByRestaurantId(foodItemRequestDTO.getRestaurantId()))));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Food Item Not Added!!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(newFoodItem, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateFoodItem/{foodId}")
	public ResponseEntity<?> updateFoodItem(@PathVariable int foodId, FoodItemRequestDTO foodItemRequestDTO) throws IOException {
		FoodItem foodItem = foodItemService.findByFoodId(foodId);
		foodItem.setFoodName(foodItemRequestDTO.getFoodName());
		foodItem.setFoodCategory(foodItemRequestDTO.getFoodCategory());
		return new ResponseEntity<>(
				foodItemService.updateFoodItem(foodItemRequestDTO, foodItemRequestDTO.getThumbnail(), foodId),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteFoodItem/{foodId}")
	public ResponseEntity<String> deleteFoodItemById(@PathVariable int foodId) {
		try {
			foodItemService.deleteFoodItem(foodId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Enter Valid Food Item", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Food Item deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/allFoodItem")
	public ResponseEntity<List<FoodItem>> getAllFoodItems() {
		return new ResponseEntity<List<FoodItem>>(foodItemService.findAllFoodItems(), HttpStatus.OK);
	}
	
	@GetMapping("/getFoodItem/{foodId}")
	public ResponseEntity<FoodItemDetailsDTO> getFoodItem(@PathVariable int foodId) {
		return new ResponseEntity<FoodItemDetailsDTO>(foodItemService.findFoodItem(foodId), HttpStatus.OK);
	}

	@GetMapping("/getFoodItemsByRestaurant/{restuarantId}")
	public ResponseEntity<?> getAllFoodItemsByRestaurant(@PathVariable int restuarantId) {
		List<FoodItemDetailsDTO> foodItemsDetailsDtoList = foodItemService.getByRestaurantId(restuarantId);
		return new ResponseEntity<>(foodItemsDetailsDtoList, HttpStatus.OK);
	}

	@PostMapping("/addOffer")
	public ResponseEntity<?> addFoodOffer(@RequestBody FoodItemResponseDTO foodItemRequestDto) {
		FoodItem foodItem = foodItemService.findByFoodId(foodItemRequestDto.getFoodId());
		foodItem.setOffer(foodItemRequestDto.getOffer());
		return new ResponseEntity<>(foodItemService.updateOffer(foodItem), HttpStatus.OK);
	}

	@PutMapping("/removeOffer/{foodId}")
	public ResponseEntity<?> removeFoodOffer(@PathVariable int foodId) {
		FoodItem foodItem = foodItemService.findByFoodId(foodId);
		foodItem.setOffer(0);
		return new ResponseEntity<>(foodItemService.updateOffer(foodItem), HttpStatus.OK);
	}

	@PutMapping("/updateOffer/{foodId}")
	public ResponseEntity<?> updateFoodOffer(@PathVariable int foodId, FoodItemRequestDTO foodItemRequestDTO) {
		FoodItem foodItem = foodItemService.findByFoodId(foodId);
		foodItem.setOffer(foodItemRequestDTO.getOffer());
		return new ResponseEntity<>(foodItemService.updateOffer(foodItem), HttpStatus.OK);
	}

	@GetMapping("/allOffers")
	public ResponseEntity<List<FoodItem>> getAllFoodOffer() {
		return new ResponseEntity<List<FoodItem>>(foodItemService.findByOfferNot(0.0d), HttpStatus.OK);
	}

	@GetMapping("/getFoodWithoutOffer")
	public ResponseEntity<List<FoodItem>> getAllFoodWithoutOffer() {
		return new ResponseEntity<List<FoodItem>>(foodItemService.findByOffer(0.0d), HttpStatus.OK);
	}
}
