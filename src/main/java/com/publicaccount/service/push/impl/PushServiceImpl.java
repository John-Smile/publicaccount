package com.publicaccount.service.push.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.publicaccount.service.email.EmailService;
import com.publicaccount.service.push.PushService;

@Service
public class PushServiceImpl implements PushService {
	@Resource
	private EmailService emailService;

	@Override
	public void push(String[] emailAddress, String fileName, byte[] file) {
		emailService.sendFile(emailAddress, fileName, file);
	}

}
