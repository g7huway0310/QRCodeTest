package com.example.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.MailService;



@SpringBootTest
class DemoApplicationTests {

	
	@Autowired
    private MailService mailService;

    public void testSend() throws IOException, MessagingException {
    	String to = "[email protected]";
		mailService.sendEMail(to, "模板郵件", UUID.randomUUID().toString().toUpperCase());
		
		try {
			mailService.readMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Test
	void contextLoads() {
	}

}
