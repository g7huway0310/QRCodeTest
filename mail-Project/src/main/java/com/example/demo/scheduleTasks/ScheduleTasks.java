package com.example.demo.scheduleTasks;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	

}
