package com.example.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.controller.MailController;
import com.example.demo.service.MailService;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DemoApplication {

	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private MailController mailController;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); 	
	}
	
	@Scheduled(fixedDelay = 120000)
	public void triggerWhenStart() throws MessagingException, IOException {

	}

}
