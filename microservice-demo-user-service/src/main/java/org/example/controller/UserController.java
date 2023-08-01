package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.dto.UserDto;
import org.example.exception.UserNotFoundException;
import org.example.model.UserEntity;
import org.example.service.UserService;
import org.example.ui.UserRequestUi;
import org.example.ui.UserResponseUi;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final ModelMapper modelMapper;
	
	@PostMapping("/save")
	public ResponseEntity<UserResponseUi> saveUser(@RequestBody UserRequestUi userRequestUi){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestUi, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = userService.addUser(userDto);
		UserResponseUi userResponseUi = modelMapper.map(userEntity, UserResponseUi.class);
		return ResponseEntity.ok(userResponseUi);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<UserResponseUi>> showAllUsers(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseUi> userResponseList = new ArrayList<>();
		List<UserEntity> userList = userService.showAllUsers();
		for (UserEntity u: userList){
			UserResponseUi tempUser = modelMapper.map(u, UserResponseUi.class);
			userResponseList.add(tempUser);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(userResponseList);
		
	}
	
	@GetMapping("/find/{userId}")
	public ResponseEntity<?> findByUserId(@PathVariable("userId") String userId){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = userService.findByUserId(userId);
		if (userEntity==null) {
			throw new UserNotFoundException("Employee with ID: "+userId+" not found");
		}else {
			UserResponseUi userResponseUi = modelMapper.map(userEntity, UserResponseUi.class);
			return ResponseEntity.status(HttpStatus.FOUND).body(userResponseUi);
		}
		
	}
	
	@PostMapping("/update/{userId}")
	public ResponseEntity<?> updateByUserId(@PathVariable("userId") String userId,@RequestBody UserRequestUi userRequestUi){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestUi, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = userService.updateByUserId(userId, userDto);
		UserResponseUi userResponseUi = modelMapper.map(userEntity, UserResponseUi.class);
		return ResponseEntity.status(HttpStatus.FOUND).body(userResponseUi);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteByUserId(@PathVariable("userId") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteByUserId(userId));
	}
	
}
