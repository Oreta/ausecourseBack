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

			return userRepository.findById(id);
	}


	@Override
	public void push(User user) {
		userRepository.save(user);
		
	}


	@Override
	public void emailValide(String id) {
		Optional<User> user = userRepository.findById(id);
		User userOk=null;
		if(user.isPresent()) {
			 userOk = user.get();
		}
		userOk.setEmailValide(true);
		userRepository.save(userOk);
		System.out.println(userRepository.findById(id));
		
	}

}
