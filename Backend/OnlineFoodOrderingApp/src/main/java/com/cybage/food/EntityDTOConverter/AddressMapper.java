package com.cybage.food.EntityDTOConverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.cybage.food.dto.AddressDTO;
import com.cybage.food.entity.Address;

@Component
public class AddressMapper {
	ModelMapper modelMapper = new ModelMapper();

	public AddressDTO toAddressDto(Address address) {
		return modelMapper.map(address, AddressDTO.class);
	}

	public Address toAddressEntity(AddressDTO addressDto) {
		return modelMapper.map(addressDto, Address.class);
	}
	
}
