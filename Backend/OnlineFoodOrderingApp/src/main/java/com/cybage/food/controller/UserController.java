package com.cybage.food.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cybage.food.dto.UserDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodapp")
public class UserController {

	@Autowired
	RestTemplate restTemplate;
	

	@PostMapping("/registration")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) {
		String url = "http://localhost:8082/api/foodapp/loginService/registration";
		return (ResponseEntity<UserDTO>) restTemplate.postForEntity(url, userDto, UserDTO.class);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserDTO userDto) {
		try {
		String url = "http://localhost:8082/api/foodapp/loginService/login";
		return (ResponseEntity<String>) restTemplate.postForEntity(url, userDto, String.class);
		}catch (HttpStatusCodeException ex) {
		    if(ex.getRawStatusCode()==404)
		    return new ResponseEntity<String>(ex.getResponseBodyAsString() , HttpStatus.NOT_FOUND);
		    else if(ex.getRawStatusCode()==423)
		    	  return new ResponseEntity<String>(ex.getResponseBodyAsString() , HttpStatus.LOCKED);
		    else
		    	  return new ResponseEntity<String>(ex.getResponseBodyAsString() , HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/sendOTP")
	public ResponseEntity<String> sendOtp(@RequestBody UserDTO userDto) {
		String url = "http://localhost:8082/api/foodapp/loginService/sendOTP";
		return (ResponseEntity<String>) restTemplate.postForEntity(url, userDto, String.class);
	}
	
	@GetMapping("/validateOTP/{otp}/{email}")
	public ResponseEntity<String> validateOtp(@PathVariable int otp, @PathVariable String email) {
		String url = "http://localhost:8082/api/foodapp/loginService/ validateOTP/"+otp+"/"+email;
		return (ResponseEntity<String>) restTemplate.getForEntity(url, String.class);
	}
}
