package com.cybage.food.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.food.EntityDTOConverter.RestaurantMapper;
import com.cybage.food.dao.RestaurantRepository;
import com.cybage.food.dto.RestaurantLoginDTO;
import com.cybage.food.dto.RestaurantRequestDTO;
import com.cybage.food.dto.RestaurantResponseDTO;
import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.Address;
import com.cybage.food.entity.Restaurant;
import com.cybage.food.exception.CustomException;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	FileService fileService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	RestaurantMapper restaurantMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public RestaurantResponseDTO addRestaurant(RestaurantRequestDTO restaurantRequestDto){
		
		//String fileName = fileService.save(thumbnail);
		Restaurant restaurant = restaurantMapper.toRestaurantEntity(restaurantRequestDto);
		//restaurant.setThumbnail(fileName);
		restaurant.setRestaurantPassword(passwordEncoder.encode(restaurantRequestDto.getRestaurantPassword()));
		return restaurantMapper.toRestaurantResponseDto(restaurantRepository.save(restaurant));
	}

	public String deleteByRestaurantId(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
		return "Restaurant deleted successfully";
	}

	public RestaurantResponseDTO updateRestaurant(Restaurant restaurant, MultipartFile thumbnail) throws IOException {
		if(thumbnail != null) {
		String fileName = fileService.save(thumbnail);
		restaurant.setThumbnail(fileName);
		}
		return restaurantMapper.toRestaurantResponseDto(restaurantRepository.save(restaurant));
	}

	public List<RestaurantResponseDTO> findAllRestaurants() {
		List<Restaurant> restaurantList = restaurantRepository.findAll();
		List<RestaurantResponseDTO> restaurantResponseDtoList = new ArrayList<>();
		for(int i=0 ; i<restaurantList.size(); i++) {
			RestaurantResponseDTO restaurantResponseDto = restaurantMapper.toRestaurantResponseDto(restaurantList.get(i));
			restaurantResponseDtoList.add(restaurantResponseDto);
		}
		return restaurantResponseDtoList;
	}

	public List<Restaurant> findRestaurantByArea(Address address) {
		return restaurantRepository.findByAddress(address);
	}

//	public FileSystemResource findByThumbnail(String thumbnail) {
//		return storageService.load(thumbnail);
//	}

	public RestaurantResponseDTO findByRestaurantEmailAndRestaurantPassword(String email, String password) throws CustomException{
		Restaurant restaurant = findByRestaurantEmail(email);
		if (restaurant == null) {
			throw new CustomException("restaurant not found");
		}
		if (passwordEncoder.matches(password, restaurant.getRestaurantPassword()) && restaurant.getAttemptCount() <= 3) {
			restaurant.setAttemptCount(0);
			restaurantRepository.save(restaurant);
			return restaurantMapper.toRestaurantResponseDto(restaurant);
		} else {
			restaurant.setAttemptCount(restaurant.getAttemptCount() + 1);
			restaurantRepository.save(restaurant);
			return null;
		}
	}

	public Restaurant findByRestaurantId(int restaurantId) {
		return restaurantRepository.findByRestaurantId(restaurantId);
	}

	public List<Restaurant> restList() {
		return restaurantRepository.findAll();
	}

	public List<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}

	public int restcount() {
		return (int) restaurantRepository.count();
	}

	public Restaurant findByRestaurantEmail(String email) {
		return restaurantRepository.findByRestaurantEmail(email);
	}
	
	public RestaurantResponseDTO findByRestaurantEmailReturnResponseDto(String email) {
		return restaurantMapper.toRestaurantResponseDto(restaurantRepository.findByRestaurantEmail(email));
	}
	
	public void sendEmail(String email,String password) {
		try {
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom("Trng2@evolvingsols.com");
			message.setTo(email);
			message.setText("Congrats... Your restaurant is live on our website!!!\n"
					+ "Your login details are as here: \n"
					+ "Email:" +email+"\n"+ "Password:" +password);
			message.setSubject("Restaurant Owner Crediantials");
			mailSender.send(message);
		} catch (MailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}	

}
