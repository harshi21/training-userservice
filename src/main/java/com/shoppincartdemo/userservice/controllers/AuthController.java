package com.shoppincartdemo.userservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shoppincartdemo.userservice.models.User;
import com.shoppincartdemo.userservice.requestPOJO.RegistrationRequest;
import com.shoppincartdemo.userservice.requestPOJO.SendEmailRequest;
import com.shoppincartdemo.userservice.services.SendEmailFeignClient;
import com.shoppincartdemo.userservice.services.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SendEmailFeignClient fClient;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/registration")
	public ResponseEntity<String> registration(@RequestBody RegistrationRequest rRequest){
		User user1 = this.userService.getUserByEmail(rRequest.getEmail());
		if(user1 != null) {
			 
			return ResponseEntity.badRequest().body("Email already exists");
		}
		User user = new User();
		user.setEmail(rRequest.getEmail());
		user.setName(rRequest.getName());
		user.setPassword(rRequest.getPassword());
		user.setIsActive(true);
		User savedUser = this.userService.saveUser(user);
		SendEmailRequest emailRequest = new SendEmailRequest();
		emailRequest.setEmailId(user.getEmail());
		emailRequest.setEmailType("ACTIVATION EMAIL");
		emailRequest.setPersonName(user.getName());
		logger.info("{}",emailRequest);
		//this.restTemplate.postForObject("http://localhost:8090/send-email", emailRequest, SendEmailRequest.class);s
		SendEmailRequest ser = this.fClient.sendEmailFeignClient(emailRequest);
		System.out.println("----------------------------------");
		logger.info("{}",ser);
		return ResponseEntity.ok().body("Saved Successfully");
		
	}
}
