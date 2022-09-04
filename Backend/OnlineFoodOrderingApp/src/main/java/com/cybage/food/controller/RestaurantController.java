package com.cybage.food.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.springframework.web.multipart.MultipartFile;

import com.cybage.food.dto.RestaurantLoginDTO;
import com.cybage.food.dto.RestaurantRequestDTO;
import com.cybage.food.dto.RestaurantResponseDTO;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.OrderInfo;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.exception.CustomException;
import com.cybage.food.service.FoodItemService;
import com.cybage.food.service.OrderService;
import com.cybage.food.service.RestaurantService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/rest")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	@Autowired
	FoodItemService foodItemService;
	
	@Autowired
	OrderService orderService;

	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantResponseDTO> addRestaurant(@RequestBody RestaurantRequestDTO restaurantRequestDTO)
			throws CustomException {
		RestaurantResponseDTO newRestaurant = null;
		try {
			int distance = (int) (Math.floor(Math.random() * 5) * 5);
			restaurantRequestDTO.setDistance(Integer.toString(distance));
		
			newRestaurant = restaurantService.addRestaurant(restaurantRequestDTO);
			if(newRestaurant!=null)
			restaurantService.sendEmail(restaurantRequestDTO.getRestaurantEmail(),
					restaurantRequestDTO.getRestaurantPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Restaurant Not Added");
		}
		return new ResponseEntity<RestaurantResponseDTO>(newRestaurant, HttpStatus.OK);
	}

	@PutMapping("/updateRestaurant/{restaurantId}")
	public ResponseEntity<?> updateRestaurant(@PathVariable int restaurantId,
			RestaurantRequestDTO restaurantRequestDTO) throws IOException {
		Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
		if (restaurantRequestDTO.getRestaurantName() != null)
			restaurant.setRestaurantName(restaurantRequestDTO.getRestaurantName());
		if (restaurantRequestDTO.getRestaurantUserName() != null)
			restaurant.setRestaurantUserName(restaurantRequestDTO.getRestaurantUserName());
		return new ResponseEntity<>(restaurantService.updateRestaurant(restaurant, restaurantRequestDTO.getThumbnail()),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteRestaurant/{restaurantId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int restaurantId) throws CustomException {
		String response = "";
		List<FoodItem> restaurantFood = foodItemService.getByRestaurantIdReturnsFoodItemList(restaurantId);
		if (restaurantFood != null) {
			for (FoodItem foodItem : restaurantFood) {
				if (foodItem.getOrderInfo().size() != 0) {
					throw new CustomException("Restaurant not deleted have orders");
				}
			}
		}
		response = restaurantService.deleteByRestaurantId(restaurantId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/getImage")
	public ResponseEntity<String> getImage(MultipartFile file){
		System.out.println(file.getOriginalFilename());
		return new  ResponseEntity<String>(file.getOriginalFilename() , HttpStatus.OK);
	}

	@GetMapping("/allRestaurant")
	public ResponseEntity<List<RestaurantResponseDTO>> getAllRestaurant() {
		return new ResponseEntity<List<RestaurantResponseDTO>>(restaurantService.findAllRestaurants(), HttpStatus.OK);
	}

//	@GetMapping("/{thumbnail}")
//	public Resource findThumbnail(@PathVariable String thumbnail) {
//		return restaurantService.findByThumbnail(thumbnail);
//	}

	@GetMapping("/getRestaurantById/{restaurantId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int restaurantId) {
		return new ResponseEntity<Restaurant>(restaurantService.findByRestaurantId(restaurantId), HttpStatus.OK);
	}

	@GetMapping("/searchByRating/{rating}")
	public ResponseEntity<?> findRestaurantByRating(@PathVariable int rating){
		Set<OrderInfo> list = orderService.findByFoodRating().stream().filter(element->rating == element.getFoodRating()).collect(Collectors.toSet());		 
		 return new ResponseEntity<>(list.stream().map(element->element.getFoodItems().getRestaurant()).collect(Collectors.toSet()),HttpStatus.OK);
	}
		
	@PostMapping("/login")
	public ResponseEntity<?> restaurantLogin(@RequestBody RestaurantLoginDTO restaurantLoginDTO) throws CustomException {
		RestaurantResponseDTO restaurantResponseDTO = restaurantService.findByRestaurantEmailAndRestaurantPassword(restaurantLoginDTO.getRestaurantEmail(),
				restaurantLoginDTO.getRestaurantPassword());
		Restaurant restaurant = restaurantService.findByRestaurantEmail(restaurantLoginDTO.getRestaurantEmail());
		RestaurantResponseDTO restaurantResponseDTO1 = restaurantService.findByRestaurantEmailReturnResponseDto(restaurantLoginDTO.getRestaurantEmail());
		if (restaurantResponseDTO == null) {
			if (restaurant.getAttemptCount() <= 3) {
				return new ResponseEntity<>("Email or password is wrong", HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Your account has been blocked. contact admin", HttpStatus.LOCKED);
			}
		} else {
			return new ResponseEntity<>(restaurantResponseDTO1, HttpStatus.OK);
		}
	}

}
