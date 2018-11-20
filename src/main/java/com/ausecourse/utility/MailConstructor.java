package com.ausecourse.utility;

import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;


import com.ausecourse.model.User;




@Component
public class MailConstructor {
	
	@Autowired 
	private Environment env ; 

	
	public SimpleMailMessage construcNewUserEmail(User user, String password) {
		String message = "your account has been successfuly created !" ;
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("AuSeCourse - New User");
		email.setText(message);
		email.setFrom(env.getProperty("support.email"));
		return email; 

		
	}



}
