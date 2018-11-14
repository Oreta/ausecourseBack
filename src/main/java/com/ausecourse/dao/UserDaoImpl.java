package com.ausecourse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.ausecourse.model.User;
import com.ausecourse.repository.UserRepository;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> getById(String id) {
		try {
			return userRepository.findById(id);
		}catch(Exception e){
			System.out.println(" msg: "+e.getMessage()+" local "+e.getLocalizedMessage()+" stacktrave"+e.getStackTrace());
		}
		
		return null;
	}
	
	public User user(int id) {
		
		
		return new User("1");
	}

	@Override
	public void push(User user) {
		System.out.println("user try push");
		userRepository.save(user);
		
		System.out.println("eoooe"+userRepository.findById(user.getId()+""));
		
	}

}
