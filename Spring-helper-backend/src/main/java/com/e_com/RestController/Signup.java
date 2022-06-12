package com.e_com.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.Entity.Users;

@RestController
@RequestMapping("/api")
public class Signup {

	public Signup() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/signup")
	public void signupForUser(@RequestBody Users theUser) {
		System.out.println(theUser);
	}
	
	

}
