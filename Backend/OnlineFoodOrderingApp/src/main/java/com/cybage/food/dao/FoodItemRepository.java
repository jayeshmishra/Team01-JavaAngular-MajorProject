package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{
	@Query(nativeQuery = true, value="select * from food_item where restaurant_id=?1")
	public List<FoodItem> findFoodByRestaurantId(int restuarantId);
	public List<FoodItem> findByOfferNot(double offer);
	public List<FoodItem> findByOffer(double offer);
	public FoodItem findByFoodId(int foodId);
}
