package com.cybage.food.EntityDTOConverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cybage.food.dto.OrderHistoryDTO;
import com.cybage.food.entity.OrderInfo;
import com.cybage.food.entity.UserOrder;

@Component
public class OrderMapper {
	
	public List<OrderHistoryDTO> toUserOrder(List<UserOrder> userOrderList){
		List<OrderHistoryDTO> orderHistoryDTOs = new ArrayList<>();
	
		for(UserOrder userOrder : userOrderList) {
			orderHistoryDTOs.add(toOrderHistoryDto(userOrder));
		}
		return orderHistoryDTOs;
	}
	
	public OrderHistoryDTO toOrderHistoryDto(UserOrder userOrder) {
		OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO();
		List<String> foodNameList = new ArrayList<>();
		orderHistoryDTO.setOrderId(userOrder.getOrderId());
		orderHistoryDTO.setOrderStatus(userOrder.getOrderStatus());
		orderHistoryDTO.setOrderTime(userOrder.getOrderTime());
		orderHistoryDTO.setRestaurantName(userOrder.getRestaurant().getRestaurantName());
		for(OrderInfo orderInfo: userOrder.getOrderInfo()) {
			foodNameList.add(orderInfo.getFoodItems().getFoodName());
		}
		orderHistoryDTO.setFoodName(foodNameList);
		orderHistoryDTO.setTotalAmount(userOrder.getTotalAmount());
		return orderHistoryDTO;
	}
	
}
