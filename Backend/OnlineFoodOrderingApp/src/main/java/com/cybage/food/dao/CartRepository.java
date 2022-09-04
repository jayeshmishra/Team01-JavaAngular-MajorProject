package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.Cart;
import com.cybage.food.entity.FoodItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	public Cart findByCartId(int cartId);
	@Query("select foodItems from Cart where cartId=?1")
	public List<FoodItem> findFoodItemsInCart(int cartId);
	
}
