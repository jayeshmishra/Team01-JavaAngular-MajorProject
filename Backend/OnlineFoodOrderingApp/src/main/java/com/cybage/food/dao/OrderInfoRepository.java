package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.OrderInfo;
import com.cybage.food.entity.UserOrder;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer>{
	public List<OrderInfo> findByUserOrder(UserOrder userOrder);
	public OrderInfo findBySerialNo(int serialNumber);
}
