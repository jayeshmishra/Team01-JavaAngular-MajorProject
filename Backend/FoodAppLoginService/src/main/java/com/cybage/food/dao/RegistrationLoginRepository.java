package com.cybage.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.User;
import com.cybage.food.exception.CustomException;

@Repository
public interface RegistrationLoginRepository extends JpaRepository<User, Integer>{
	public User findByUserEmail(String email);
	public User findByUserEmailAndUserPassword(String email, String password) throws CustomException ;
}
