package com.cybage.food.EntityDTOConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cybage.food.dto.RestaurantLoginDTO;
import com.cybage.food.dto.RestaurantRequestDTO;
import com.cybage.food.dto.RestaurantResponseDTO;
import com.cybage.food.entity.Address;
import com.cybage.food.entity.Restaurant;

@Component
public class RestaurantMapper {

	public Restaurant toRestaurantEntity(RestaurantRequestDTO dto) {
		Restaurant entity = new Restaurant();
		entity.setAddress(new Address(dto.getArea(), dto.getStreet(), dto.getPincode()));
		BeanUtils.copyProperties(dto, entity, "thumbnail");
		return entity;
	}

	public RestaurantResponseDTO toRestaurantResponseDto(Restaurant entity) {
		RestaurantResponseDTO restaurantResponseDTO = new RestaurantResponseDTO();
		BeanUtils.copyProperties(entity, restaurantResponseDTO);
		restaurantResponseDTO.setAddressId(entity.getAddress().getAddressId());
		restaurantResponseDTO.setArea(entity.getAddress().getArea());
		restaurantResponseDTO.setStreet(entity.getAddress().getStreet());
		restaurantResponseDTO.setPincode(entity.getAddress().getPincode());
		return restaurantResponseDTO;
	}
	
	public RestaurantLoginDTO toRestaurantLoginDTO(Restaurant restaurant) {
		RestaurantLoginDTO restaurantLoginDTO = new RestaurantLoginDTO();
		restaurantLoginDTO.setRestaurantEmail(restaurant.getRestaurantEmail());
		restaurantLoginDTO.setRestaurantPassword(restaurant.getRestaurantPassword());
		return restaurantLoginDTO;
	}

}
