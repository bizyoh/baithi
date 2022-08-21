package com.demo.services;

import java.util.Date;

import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void send(String from, String to, String subject, Object content) throws Exception {
		MimeMessage mimeMessage = sender.createMimeMessage();
		mimeMessage.setFrom(from);
		mimeMessage.setRecipients(RecipientType.TO, to);
		mimeMessage.setSubject(subject);
		mimeMessage.setContent(content, "text/html");
		mimeMessage.setSentDate(new Date());
		sender.send(mimeMessage);
		
	}

}
