package com.e_com.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.e_com.Entity.CustomUserdetails;
import com.e_com.Entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	public CustomUserDetailService() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userService.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}else {
			return new CustomUserdetails(user);
		}
	}

}
