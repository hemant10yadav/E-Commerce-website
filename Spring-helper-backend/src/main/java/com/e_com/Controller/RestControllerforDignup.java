package com.e_com.Controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.Sevice.UserServiceDao;



@RestController
@RequestMapping("/api")
public class RestControllerforDignup {
	
	private Logger log;
	
	private UserServiceDao userServiccedao;

	public RestControllerforDignup() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@PostMapping("/signup")
	public String signupForUser() {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "dsafasfasdfadfadsfasdfsadf";
	}
	
	
}
