package org.example.service;

import java.util.List;

import org.example.dto.UserDto;
import org.example.model.UserEntity;

public interface UserService {
	
	UserEntity addUser(UserDto userDto);
	
	List<UserEntity> showAllUsers();
	
	UserEntity findByUserId(String userId);
	
	UserEntity updateByUserId(String userId, UserDto userDto);
	
	String deleteByUserId(String userId);
	
}
