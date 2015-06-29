package com.xc.forum.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sigon(){
		return "login/login.html";
	}
}
