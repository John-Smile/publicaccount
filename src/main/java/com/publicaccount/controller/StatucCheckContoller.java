package com.publicaccount.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicaccount.controller.dto.Resp;

@RestController
@RequestMapping("/status")
public class StatucCheckContoller {

	@RequestMapping(value = "/alive", method = RequestMethod.GET)
	public Resp isAlive() {
		return Resp.SUCCESS;
	}
}
