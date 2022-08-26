package com.cybage.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.dto.UserDTO;
import com.cybage.food.exception.CustomException;
import com.cybage.food.service.OtpService;
import com.cybage.food.service.RegistrationLoginService;

@RestController
@RequestMapping("/api/foodapp/loginService")
public class RegistrationLoginController {

	@Autowired
	RegistrationLoginService registrationLoginService;

	@Autowired
	OtpService otpService;

	@PostMapping("/registration")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO UserDto) {
		return new ResponseEntity<UserDTO>(registrationLoginService.registerUser(UserDto), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserDTO UserDto) throws CustomException {
		UserDTO loginUserDto = registrationLoginService.findByUserEmailAndUserPassword(UserDto.getUserEmail(),
				UserDto.getUserPassword());
		UserDTO userDto = registrationLoginService.findByUserEmail(UserDto.getUserEmail());
		if (loginUserDto == null) {
			if (userDto.getAttemptCount() <= 3) {
				return new ResponseEntity<>("Email or password is wrong", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Your account has been blocked. contact admin", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		}
	}

	@PostMapping("/sendOTP")
	public ResponseEntity<String> sendOtp(@RequestBody UserDTO userDto) {
		String email = userDto.getUserEmail();
		int otp = otpService.generateOTP(email);
		return new ResponseEntity<String>(registrationLoginService.sendOtp(email, otp), HttpStatus.OK);
	}

	@GetMapping("/validateOTP/{otp}/{email}")
	public ResponseEntity<String> validateOtp(@PathVariable int otp, @PathVariable String email) {
		if (otp >= 0) {
			int serverOtp = otpService.getOtp(email);
			if (serverOtp > 0) {
				if (otp == serverOtp) {
					otpService.clearOTP(email);
					return new ResponseEntity<String>("OTP is valid" , HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("OTP is invalid" , HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<String>("OTP is invalid" , HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>("OTP is invalid" , HttpStatus.OK);
		}
	}
}
