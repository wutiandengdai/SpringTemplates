package com.framework.spring.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		return "Welcome, "+ " You were logged in at : " + new Date();
	}
}
