package com.publicaccount.controller.test;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicaccount.controller.dto.Resp;
import com.publicaccount.service.kindle.KindleService;


@RestController
@RequestMapping("/test")
public class PushTestController {
	@Resource
	private KindleService kindleService;
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public Resp testPush(String emailAddress, String fileName) {
		System.out.println(System.getProperty("user.dir"));
		String absoluteDiskPath = System.getProperty("catalina.base");
		System.out.println(absoluteDiskPath);
		kindleService.searchAndPush(emailAddress, fileName);
		return Resp.SUCCESS;
	}

}
