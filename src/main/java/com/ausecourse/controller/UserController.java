package com.ausecourse.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.User;

public class UserController {
//routes
	IUserDao uDao;
	
	@CrossOrigin()
	@RequestMapping(value = "/UserGetById", method = RequestMethod.GET)
	public Optional<User> UserGetById(String id) {
		return uDao.getById(id);
	}
}