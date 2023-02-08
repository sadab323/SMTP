package com.sa.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class JavaMail {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String subject, String body) {
	    MimeMessage message = javaMailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(body, true);

	        javaMailSender.send(message);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}