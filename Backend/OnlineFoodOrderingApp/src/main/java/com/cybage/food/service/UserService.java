package com.cybage.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.UserRepository;
import com.cybage.food.entity.User;

@Service
public class UserService{

	@Autowired
	private UserRepository userDao;
	
}
