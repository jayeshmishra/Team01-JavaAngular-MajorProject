package com.cybage.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.Feedback;
import com.cybage.food.entity.User;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	List<Feedback> findByUser(User user);

}
