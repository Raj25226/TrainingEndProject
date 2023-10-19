package com.mj.service;

public interface MailSenderService {
	
	public void sendNewMail(String to, String subject, String body);

}
