package com.cybage.food.EntityDTOConverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.User;

@Component
public class RegistrationLoginMapper {
	ModelMapper modelMapper = new ModelMapper();
	public UserDTO toUserDto(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public User toUserEntity(UserDTO userDto) {
		return modelMapper.map(userDto, User.class);
	}
}
