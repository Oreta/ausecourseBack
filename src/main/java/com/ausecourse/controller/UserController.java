package com.ausecourse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ausecourse.dao.IUserDao;
import com.ausecourse.dao.UserDaoImpl;
import com.ausecourse.model.User;

@RestController
public class UserController {
//routes
	@Autowired
	IUserDao udao;	
	@RequestMapping(value = "/UserGetById", method = RequestMethod.GET)
	
	public Optional<User> UserGetById(@RequestParam("id") String id) {
		try {
			return udao.getById(id);
		}catch(Exception e){
			System.out.println(" msg: "+e.getMessage()+" local "+e.getLocalizedMessage()+" stacktrave"+e.getStackTrace());
		}
		return null;
		
	}
}