package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.Restaurant;
import com.cybage.food.entity.User;
import com.cybage.food.entity.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>{
	public List<UserOrder> findByRestaurant(Restaurant restaurant);
	public List<UserOrder> findByUser(User user);
	public UserOrder findByOrderId(int orderId);
}
