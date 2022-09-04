package com.cybage.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.EntityDTOConverter.AddressMapper;
import com.cybage.food.EntityDTOConverter.UserMapper;
import com.cybage.food.dao.UserRepository;
import com.cybage.food.dto.AddressDTO;
import com.cybage.food.dto.UserAddressDTO;
import com.cybage.food.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AddressMapper addressMapper;
	
	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User findByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	public UserAddressDTO addAddressForUser(AddressDTO addressDto , int userId) {
		User user  = findByUserId(userId);
		user.setAddress(addressMapper.toAddressEntity(addressDto));
		return userMapper.toUserAddressDto(userRepository.save(user));
	}


	public User updateUserInfo(int userId, UserAddressDTO userAddressDto) {
		User user = findByUserId(userId);
		int addressId = user.getAddress().getAddressId();
		userAddressDto.setUserId(userId);
		User user1 = userMapper.toUserEntity(userAddressDto , addressId);
		user1.setUserPassword(user.getUserPassword());
		return userRepository.save(user1);
	}
	
	public List<UserAddressDTO> findAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserAddressDTO> userAddressDtoList = new ArrayList<>();
		for(int i=0 ; i<userList.size(); i++) {
			UserAddressDTO userAddressDto = userMapper.toUserAddressDto(userList.get(i));
			userAddressDtoList.add(userAddressDto);
		}
		return userAddressDtoList;
	}

	public Object findAllLockedUsers() {
		List<User> userList = userRepository.findAll();
		List<UserAddressDTO> blockedUserList = new ArrayList<>();
		for(User user : userList) {
			if(user.getAttemptCount()>=3) {
				blockedUserList.add(userMapper.toUserAddressDto(user));
			}
		}
		return blockedUserList;
	}
}
