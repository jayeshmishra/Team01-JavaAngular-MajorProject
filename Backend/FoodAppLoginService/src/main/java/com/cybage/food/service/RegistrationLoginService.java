package com.cybage.food.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.food.EntityDTOConverter.RegistrationLoginMapper;
import com.cybage.food.dao.RegistrationLoginRepository;
import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.User;
import com.cybage.food.exception.CustomException;

@Service
public class RegistrationLoginService {
	@Autowired
	RegistrationLoginRepository registrationLoginRepository;

	@Autowired
	RegistrationLoginMapper registrationLoginMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender javaMailSender;


	public UserDTO registerUser(UserDTO userDto) {
		userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
		return registrationLoginMapper.toUserDto(registrationLoginRepository.save(registrationLoginMapper.toUserEntity(userDto)));
	}

	public UserDTO findByUserEmail(String email) {
		if (registrationLoginRepository.findByUserEmail(email) == null) {
			return null;
		} else {
			return registrationLoginMapper.toUserDto(registrationLoginRepository.findByUserEmail(email));
		}
	}

	public UserDTO findByUserEmailAndUserPassword(String email, String password) throws CustomException {
		UserDTO userDto = findByUserEmail(email);
		if (userDto == null) {
			throw new CustomException("user not found");
		}
		if (passwordEncoder.matches(password, userDto.getUserPassword()) && userDto.getAttemptCount() <= 3) {
			userDto.setAttemptCount(0);
			registrationLoginRepository.save(registrationLoginMapper.toUserEntity(userDto));
			return userDto;
		} else {
			userDto.setAttemptCount(userDto.getAttemptCount() + 1);
			registrationLoginRepository.save(registrationLoginMapper.toUserEntity(userDto));
			return null;
		}
	}

	public String sendOtp(String email , int otp) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setFrom("Trng2@evolvingsols.com");
			helper.setTo(email);
			helper.setText("OTP is : " + otp, true);
			helper.setSubject("OTP For Login");
			javaMailSender.send(mimeMessage);
			return ""+otp+"";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while Sending Mail";
		}
	}
}
