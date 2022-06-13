package com.e_com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_com.Entity.JwtRequest;
import com.e_com.Entity.JwtResponse;
import com.e_com.Sevice.CustomUserDetailService;
import com.e_com.Utility.JwtUtil;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class JwtController {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public JwtController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try{
			System.out.println("try");
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		}catch(UsernameNotFoundException exc){
			System.out.println("catch1");
			exc.printStackTrace();
			throw new Exception("Bad Credential");
		}catch(BadCredentialsException exc) {
			System.out.println("catch2");
			exc.printStackTrace();
			throw new Exception("Bad Credential");
		}
		
		
		UserDetails userDetails = this.customUserDetailService.
				loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtutil.generateToken(userDetails);
		System.out.println(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	

}
