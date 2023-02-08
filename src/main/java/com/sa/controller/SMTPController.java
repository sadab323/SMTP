package com.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.mail.JavaMail;

@RestController
public class SMTPController {
	
	@Autowired
	JavaMail javamail;
	
	@Autowired
	Environment env;
	
	@GetMapping(value="/mail")
	public String sendMail() {
		
		javamail.sendEmail(env.getProperty("mail","sadab323@gmail.com"),env.getProperty("subject"),env.getProperty("body"));
		return "Mail Send Successfull";
	}
	

}
