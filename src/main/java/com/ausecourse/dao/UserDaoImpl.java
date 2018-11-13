package com.ausecourse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ausecourse.model.User;
import com.ausecourse.repository.UserRepository;

public class UserDaoImpl implements IUserDao{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> getById(String id) {
		return userRepository.findById(id);
	}

}
