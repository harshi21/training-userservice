package com.shoppincartdemo.userservice.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shoppincartdemo.userservice.requestPOJO.SendEmailRequest;


//@FeignClient(name="notificationservice", url="http://localhost:8090")
@FeignClient(name="shopping-cart-api-gateway-zuul-server")
@RibbonClient(name="shopping-cart-api-gateway-zuul-server")
public interface SendEmailFeignClient {
  
	@PostMapping("/notificationservice/send-email")
	public SendEmailRequest sendEmailFeignClient(@RequestBody SendEmailRequest request);
	
	@PostMapping("/send-email-reactive")
	public SendEmailRequest sendEmailReactiveFeignClient(@RequestBody SendEmailRequest request);
}
