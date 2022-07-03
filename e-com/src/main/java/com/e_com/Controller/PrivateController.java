package com.e_com.Controller;

import com.e_com.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.e_com.Sevice.UserServiceDao;


@RestController
@RequestMapping("/api/private")
public class PrivateController {


	@Autowired
	private UserServiceDao userServiceDao;

	public PrivateController() {
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user/{theId}")
	public User getUser(@PathVariable int theId) {
		System.out.println("theid" + theId);
		return this.userServiceDao.getUser(theId);
	}

}
