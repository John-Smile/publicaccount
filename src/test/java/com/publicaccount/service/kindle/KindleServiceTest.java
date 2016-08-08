package com.publicaccount.service.kindle;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:config/publicaccount-context1.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class KindleServiceTest {
	@Resource
	private KindleService kindleService;
	@Value("${emailAddr}")
	private String emailAddr;
	@Value("${fileName}")
	private String fileName;
	
	@Test
	public void testSearchAndPush() {
		kindleService.searchAndPush(emailAddr, fileName);
	}
	

}
