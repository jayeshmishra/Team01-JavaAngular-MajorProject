package com.cybage.food.EntityDTOConverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cybage.food.dto.UserAddressDTO;
import com.cybage.food.dto.UserDTO;
import com.cybage.food.entity.Address;
import com.cybage.food.entity.User;

@Component
public class UserMapper {

	ModelMapper modelMapper = new ModelMapper();

	public UserDTO toUserDto(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public User toUserEntity(UserDTO userDto) {
		return modelMapper.map(userDto, User.class);
	}

	public User toUserEntity(UserAddressDTO userAddressDto , int addressId) {
		User user = new User();
//		user.setUserId(userAddressDto.getUserId());
//		user.setUserName(userAddressDto.getUserName());
//		user.setUserEmail(userAddressDto.getUserEmail());
//		user.setUserMobileNo(userAddressDto.getUserMobileNo());
		BeanUtils.copyProperties(userAddressDto, user);
		Address address = new Address();
		address.setAddressId(addressId);
		address.setArea(userAddressDto.getArea());
		address.setStreet(userAddressDto.getStreet());
		address.setPincode(userAddressDto.getPincode());
		user.setAddress(address);
		System.out.println(user);
		return user;
	}

	public UserAddressDTO toUserAddressDto(User user) {
		UserAddressDTO userAddressDto = modelMapper.map(user, UserAddressDTO.class);
		if(user.getAddress()!=null) {
		userAddressDto.setAddressId(user.getAddress().getAddressId());
		userAddressDto.setArea(user.getAddress().getArea());
		userAddressDto.setStreet(user.getAddress().getStreet());
		userAddressDto.setPincode(user.getAddress().getPincode());
		}
		return userAddressDto;
	}
}
