package org.example.service;

import java.util.List;

import org.example.dto.UserDto;
import org.example.model.UserEntity;
import org.example.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.example.encrypt.Encryption;
import org.example.exception.UserNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;
	private final ModelMapper modelMapper;
	
	@Override
	public UserEntity addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		userEntity.setEncryptedPassword(new Encryption(userDto.getPassword()).encrypt());
		return userRepo.save(userEntity);
		
	}

	@Override
	public List<UserEntity> showAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public UserEntity findByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepo.findByUserId(userId);
	}


	@Override
	public UserEntity updateByUserId(String userId, UserDto userDto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepo.findByUserId(userId);
		if(userEntity==null) {
			throw new UserNotFoundException("User with ID: "+userId+" not found");
		}else {
			userEntity.setFirstName(userDto.getFirstName());
			userEntity.setLastName(userDto.getLastName());
			userEntity.setEmail(userDto.getEmail());
			userEntity.setPassword(userDto.getPassword());
			userEntity.setEncryptedPassword(new Encryption(userDto.getPassword()).encrypt());
			return userRepo.save(userEntity);
		}
		
		
	}

	@Override
	public String deleteByUserId(String userId) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepo.findByUserId(userId);
		if(userEntity==null) {
			throw new UserNotFoundException("User with ID: "+userId+" not found");
		}else {
			userRepo.delete(userEntity);
			return ("User with ID: "+userId+" deleted");
		}
		
	}

}
