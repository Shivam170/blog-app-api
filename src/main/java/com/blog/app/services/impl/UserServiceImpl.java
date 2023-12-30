package com.blog.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.app.entities.User;
import com.blog.app.payloads.UserDto;
import com.blog.app.repositories.UserRepo;
import com.blog.app.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		this.userRepo.findById(userId);
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
	}

	private UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
