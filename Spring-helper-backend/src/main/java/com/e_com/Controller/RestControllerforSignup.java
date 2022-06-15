package com.e_com.Controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.Entity.Users;
import com.e_com.Sevice.UserServiceDao;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestControllerforSignup {
	
	
	@Autowired
	private UserServiceDao userServiceDao;

	public RestControllerforSignup() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
