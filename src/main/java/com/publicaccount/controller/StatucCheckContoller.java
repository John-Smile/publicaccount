package com.publicaccount.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicaccount.controller.dto.Resp;
import com.publicaccount.service.email.EmailService;

@RestController
@RequestMapping("/status")
public class StatucCheckContoller {
	@Resource
	private EmailService emailService;

	@RequestMapping(value = "/alive", method = RequestMethod.GET)
	public Resp isAlive() {
		return Resp.SUCCESS;
	}
}
