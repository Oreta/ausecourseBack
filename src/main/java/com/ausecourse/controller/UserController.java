package com.ausecourse.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.User;

@RestController
public class UserController {
//routes
	IUserDao uDao;
}