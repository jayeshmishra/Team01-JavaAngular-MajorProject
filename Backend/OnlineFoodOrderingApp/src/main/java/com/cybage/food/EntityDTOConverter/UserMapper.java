package com.cybage.food.EntityDTOConverter;

import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.User;

public class UserMapper {
	public UserDTO toUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setUserEmail(user.getUserEmail());
		userDto.setUserPassword(user.getUserPassword());
		userDto.setUserMobileNo(user.getUserMobileNo());
		userDto.setAttemptCount(user.getAttemptCount());
		return userDto;
	}

	public User toUserEntity(UserDTO userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserMobileNo(userDto.getUserMobileNo());
		user.setAttemptCount(userDto.getAttemptCount());
		return user;
	}
}
