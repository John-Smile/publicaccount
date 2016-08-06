package com.publicaccount.service.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = {"classpath:config/loan-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailServiceTest {
	@Value("${emailAddr}")
    private String emailAddr;	
	@Resource
	private EmailService emailService;
	
	@Test
	public void testSendFile() throws Exception {
		String fileName = "The C Programming Language.pdf";
		File file = new File("E:\\document\\book\\C\\The C Programming Language.pdf");
		InputStream is = new FileInputStream(file);
		byte[] bFile = new byte[(int)file.length()];
		is.read(bFile);
		is.close();
		
		emailService.sendFile(emailAddr, fileName, bFile);
	}

}
