package com.cybage.food.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cybage.food.EntityDTOConverter.UserMapper;
import com.cybage.food.dto.AddressDTO;
import com.cybage.food.dto.UserAddressDTO;
import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.User;
import com.cybage.food.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodapp")
public class UserController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	static Logger logger=LogManager.getLogger(UserController.class);

	@PostMapping("/registration")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) {
		String url = "http://localhost:8082/api/foodapp/loginService/registration";
		return (ResponseEntity<UserDTO>) restTemplate.postForEntity(url, userDto, UserDTO.class);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserDTO userDto) {
	
		try {
			String url = "http://localhost:8082/api/foodapp/loginService/login";
			logger.info("Customer "+userDto.getUserName()+" logged in");
			return (ResponseEntity<String>) restTemplate.postForEntity(url, userDto, String.class);
		} catch (HttpStatusCodeException ex) {
			if (ex.getRawStatusCode() == 404)
				return new ResponseEntity<String>(ex.getResponseBodyAsString(), HttpStatus.NOT_FOUND);
			else if (ex.getRawStatusCode() == 423)
				return new ResponseEntity<String>(ex.getResponseBodyAsString(), HttpStatus.LOCKED);
			else
				return new ResponseEntity<String>(ex.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/sendOTP")
	public ResponseEntity<String> sendOtp(@RequestBody UserDTO userDto) {
		String url = "http://localhost:8082/api/foodapp/loginService/sendOTP";
		return (ResponseEntity<String>) restTemplate.postForEntity(url, userDto, String.class);
	}

	@GetMapping("/validateOTP/{otp}/{email}")
	public ResponseEntity<String> validateOtp(@PathVariable int otp, @PathVariable String email) {
		String url = "http://localhost:8082/api/foodapp/loginService/validateOTP/" + otp + "/" + email;
		return (ResponseEntity<String>) restTemplate.getForEntity(url, String.class);
	}

	@PutMapping("/addAddress/{userId}")
	public ResponseEntity<?> addAddressOfUser(@RequestBody AddressDTO addressDto, @PathVariable int userId) {
		return new ResponseEntity<>(userService.addAddressForUser(addressDto, userId), HttpStatus.OK);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateUserInfo(@PathVariable("userId") int userId,
			@RequestBody UserAddressDTO userAddressDto) {
		return new ResponseEntity<>(userService.updateUserInfo(userId, userAddressDto), HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		User user = userService.findByUserId(id);
		if (user == null) 
			return new ResponseEntity<>("User Not Found" , HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(userMapper.toUserAddressDto(user), HttpStatus.OK);
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<?> getUserByEmailId(@PathVariable String email) {
		User user = userService.findByUserEmail(email);
		return new ResponseEntity<>(userMapper.toUserAddressDto(user), HttpStatus.OK);
	}

	@GetMapping("/allUser")
	public ResponseEntity<List<UserAddressDTO>> getAllUser() {
		List<UserAddressDTO> list = userService.findAllUsers();
		return new ResponseEntity<List<UserAddressDTO>>(list, HttpStatus.OK);
	}
}
