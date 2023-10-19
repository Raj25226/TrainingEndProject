package com.mj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEMail(String toEmail, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("vishwarajshah@gmail.com");
        msg.setTo("vishwarajtemp@gmail.com");

        msg.setSubject(subject);
        msg.setText(body);
        
        javaMailSender.send(msg);
        System.out.println("Message Sent");
	}


}
