package com.e_com.Controller;

import com.e_com.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.Sevice.UserServiceDao;


@RestController
@RequestMapping("/api")
public class PrivateController {


	@Autowired
	private UserServiceDao userServiceDao;

	public PrivateController() {
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
