package com.ausecourse.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ausecourse.config.SecurityConfig;
import com.ausecourse.config.SecurityUtility;
import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.dao.IUserDao;
import com.ausecourse.model.Order;
import com.ausecourse.model.User;
import com.ausecourse.model.security.Role;
import com.ausecourse.model.security.UserRole;
import com.ausecourse.utility.MailConstructor;

@RestController
@RequestMapping("/order")
public class OrderController {
//routes

	@Autowired
	private IOrderDAO orderDao;

	@RequestMapping(value="/push", method=RequestMethod.POST)
	public ResponseEntity push(@RequestBody Order order ) throws Exception {
		
		try{ orderDao.push(order);
		}catch(Exception e) {
			System.err.println(e.getStackTrace());
			return new ResponseEntity("push faill", HttpStatus.IM_USED);
		}
		
		return new ResponseEntity("push Success", HttpStatus.OK);
		
	}
	


}