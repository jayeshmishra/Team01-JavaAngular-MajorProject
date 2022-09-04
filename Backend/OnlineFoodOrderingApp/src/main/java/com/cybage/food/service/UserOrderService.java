package com.cybage.food.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.EntityDTOConverter.OrderMapper;
import com.cybage.food.dao.FoodItemRepository;
import com.cybage.food.dao.OrderInfoRepository;
import com.cybage.food.dao.RestaurantRepository;
import com.cybage.food.dao.UserOrderRepository;
import com.cybage.food.dao.UserRepository;
import com.cybage.food.dto.OrderDetailsDTO;
import com.cybage.food.dto.OrderHistoryDTO;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;
import com.cybage.food.entity.UserOrder;

@Service
public class UserOrderService {

	@Autowired
	UserOrderRepository userOrderRepository;

	@Autowired
	OrderInfoRepository orderInfoRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FoodItemRepository foodItemRepository;
	
	@Autowired
	OrderMapper orderMapper;

	public UserOrder placeOrder(OrderDetailsDTO orderDetails) {
		UserOrder userOrder = new UserOrder();
		userOrder.setOrderStatus("placed");
		userOrder.setTotalAmount(orderDetails.getTotal());
		userOrder.setRestaurant(restaurantRepository.findByRestaurantId(orderDetails.getRestaurantId()));
		userOrder.setUser(userRepository.findByUserId(orderDetails.getUserId()));
		LocalDateTime dateTime = LocalDateTime.now();
		userOrder.setOrderTime(dateTime);
		return userOrderRepository.save(userOrder);
	}

	public List<UserOrder> getAllOrders(Restaurant restaurant) {
		return userOrderRepository.findByRestaurant(restaurant);
	}

	public List<OrderHistoryDTO> getAllOrderForUser(User user) {
		return orderMapper.toUserOrder(userOrderRepository.findByUser(user));
	}

	public UserOrder findUserOrderByOrderId(int orderId) {
		return userOrderRepository.findById(orderId).orElse(null);
	}

	public void save(UserOrder userOrder) {
		userOrderRepository.save(userOrder);
	}

	public UserOrder cancelOrder(int orderId) {
		UserOrder order = findByOrderId(orderId);
		order.setOrderStatus("cancelled");
		System.out.println(order.getOrderStatus());
		return userOrderRepository.save(order);
	}
	
	public List<FoodItem> findAllFoodItems() {
		return foodItemRepository.findAll();
	}
	
	public UserOrder findByOrderId(int orderId) {
		return userOrderRepository.findByOrderId(orderId);
	}
}
