package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MailService;

@Controller
@EnableAsync
public class MailController {
	
	@Autowired
	private MailService mailService;

	
	@RequestMapping("/MyFirstPage")
    public String greeting(@RequestParam(value="title", required=false, defaultValue="xiao") String title, Model model) {
        model.addAttribute("name", title);
        return "index";
    }
	
	@PostMapping("/sendEmail")
	public String getUserEmail(@RequestParam(value = "inputEmail")String userMail,Model model) {
		
		System.out.println(userMail);
		
		System.out.println("start____________"); 
		
		try {
			
//			mailService.readMail();
			
			mailService.sendEMail(userMail, "test", "123");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end___________");
		
        
		
		return "success.html";
	}
	
	
	
   
}
