package com.cybage.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.OrderInfoRepository;
import com.cybage.food.dao.UserOrderRepository;
import com.cybage.food.entity.FoodItem;
import com.cybage.food.entity.OrderInfo;
import com.cybage.food.entity.UserOrder;

@Service
public class OrderService {
	@Autowired
	OrderInfoRepository orderInfoRepository;

	@Autowired
	UserOrderRepository userOrderRepository;

	public List<OrderInfo> getAllOrders() {
		List<OrderInfo> orders = orderInfoRepository.findAll();
		System.out.println(orders);
		return orders;
	}

	public void saveFoodItems(FoodItem foodItem, UserOrder order, int quantity) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setFoodItems(foodItem);
		orderInfo.setUserOrder(order);
		orderInfo.setQuantity(quantity);
		orderInfoRepository.save(orderInfo);
	}

	public List<UserOrder> orderList() {
		return userOrderRepository.findAll();
	}

	public int ordercount() {
		return (int) userOrderRepository.count();
	}

	public List<OrderInfo> getOrderDetails(int orderId) {
		UserOrder userOrder = userOrderRepository.findById(orderId).orElse(null);
		return orderInfoRepository.findByUserOrder(userOrder);
	}

	public List<OrderInfo> findByFoodRating() {
		return orderInfoRepository.findAll();
	}

	public OrderInfo findUserOrderBySerialNo(int sNumber) {
		return orderInfoRepository.findBySerialNo(sNumber);
	}

	public void save(OrderInfo userOrderInfo) {
		orderInfoRepository.save(userOrderInfo);
	}
}
