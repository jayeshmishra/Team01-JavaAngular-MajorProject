package com.cybage.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.service.UserService;

@RestController
@RequestMapping("/api/foodapp")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	
}
