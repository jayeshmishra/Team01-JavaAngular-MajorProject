package com.cybage.food.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.dto.OrderDetailsDTO;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.OrderInfo;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;
import com.cybage.food.entity.UserOrder;
import com.cybage.food.exception.CustomException;
import com.cybage.food.service.OrderInfoService;
import com.cybage.food.service.OrderService;
import com.cybage.food.service.RestaurantService;
import com.cybage.food.service.UserOrderService;
import com.cybage.food.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/order")
public class OrderController {
	
	@Autowired
	OrderInfoService orderInfoService;

	@Autowired
	UserOrderService userOrderService;

	@Autowired
	UserService userService;

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/getAllOrdersForRestaurant/{restaurantId}")
	public ResponseEntity<?> getAllOrdersForRestaurant(@PathVariable int restaurantId) {
		Restaurant restaurant = restaurantService.findByRestaurantId(restaurantId);
		List<UserOrder> orders = userOrderService.getAllOrders(restaurant);
		if (orders != null)
			return new ResponseEntity<>(orders, HttpStatus.OK);
		return new ResponseEntity<>("OrderList is Empty", HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/getAllOrdersForUser/{userId}")
	public ResponseEntity<?> getAllOrdersForUser(@PathVariable int userId) throws CustomException {
		User user = userService.findByUserId(userId);
		List<UserOrder> orders = userOrderService.getAllOrderForUser(user);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping("/getOrderDetails/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int orderId) {
		List<OrderInfo> orderDetails = orderService.getOrderDetails(orderId);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}

	@PostMapping("/place-order")
	public ResponseEntity<?> placeOrder(@RequestBody OrderDetailsDTO orderDetails) {
		UserOrder order = userOrderService.placeOrder(orderDetails);
		List<FoodItem> foodItemList = new ArrayList<>();
		for(int i=0 ; i<orderDetails.getFoodId().size(); i++) {
			foodItemList.add(userOrderService.findAllFoodItems().get(i));
		}
		for (FoodItem foodItem : foodItemList) {
			orderService.saveFoodItems(foodItem, order, foodItem.getQuantity());
		}
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@PutMapping("/updateOrderStatus/{orderStatus}/{orderId}")
	public ResponseEntity<?> updateOrderStatus(@PathVariable int orderId, @PathVariable String orderStatus) {
		UserOrder userOrder = userOrderService.findUserOrderByOrderId(orderId);
		userOrder.setOrderStatus(orderStatus);
		userOrderService.save(userOrder);
		return new ResponseEntity<>("updated", HttpStatus.OK);

	}

	@PostMapping("/check-order-status-api")
	public ResponseEntity<?> checkOrderStatusAPI(UserOrder order) {
		boolean flag = false;
		UserOrder userOrder = userOrderService.findByOrderId(order.getOrderId());
		LocalDateTime now = LocalDateTime.now();
		LocalTime orderCancelTime = userOrder.getOrderTime().toLocalTime().plusMinutes(15);
		if (userOrder.getOrderTime().toLocalDate().compareTo(now.toLocalDate()) == 0) {
			if (now.toLocalTime().compareTo(orderCancelTime) <= 0) {
				flag = true;
			}
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

	@PutMapping("/cancel-order/{orderId}")
	public ResponseEntity<?> cancelOrder(@PathVariable int orderId) {
		UserOrder userOrder = userOrderService.findByOrderId(orderId);
		LocalDateTime now = LocalDateTime.now();
		LocalTime orderCancelTime = userOrder.getOrderTime().toLocalTime().plusMinutes(15);
		if (userOrder.getOrderTime().toLocalDate().compareTo(now.toLocalDate()) == 0) {
			if (now.toLocalTime().compareTo(orderCancelTime) <= 0) {
				return new ResponseEntity<>(userOrderService.cancelOrder(orderId), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Order Can't be cancelled now", HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserOrderDetail/{serialNumber}")
	public ResponseEntity<?> getUserOrderDetail(@PathVariable int serialNumber) {
		OrderInfo userOrderInfo=orderService.findUserOrderBySerialNo(serialNumber);	
		return new ResponseEntity<>(userOrderInfo, HttpStatus.OK);
	}
	
	@PutMapping("/setRatingFeedback/{serialNumber}")
	public ResponseEntity<?> addRatingAndFeedback(@PathVariable int serialNumber, OrderInfo orderInfo) {
		OrderInfo userOrderInfo=orderService.findUserOrderBySerialNo(serialNumber);	
		userOrderInfo.setFoodRating(orderInfo.getFoodRating());
		userOrderInfo.setFeedback(orderInfo.getFeedback());
		orderService.save(userOrderInfo);
		return new ResponseEntity<>("updated", HttpStatus.OK);
	}
	
}
