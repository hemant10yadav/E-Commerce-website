package com.e_com.Controller;

import com.e_com.Entity.User;
import com.e_com.ExceptionHandler.DataBaseException;
import com.e_com.ExceptionHandler.UserException;
import com.e_com.RestClass.RestUser;
import com.e_com.Sevice.UserServiceDao;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.e_com.Entity.JwtRequest;
import com.e_com.Entity.JwtResponse;
import com.e_com.Sevice.CustomUserDetailService;
import com.e_com.Utility.JwtUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class LoginSignupController {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceDao userServiceDao;

	public LoginSignupController() {}
	
	@PostMapping("/login")
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try{
			System.out.println("try");
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new UserException("User not found exception");

		}

		UserDetails userDetails = this.customUserDetailService.
				loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtutil.generateToken(userDetails);
		System.out.println(userDetails);
		System.out.println(ResponseEntity.ok(new JwtResponse(token)));
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/signup")
	public void signupForUser(@RequestBody RestUser theUser) {
		if(theUser.getFirstName()== null || theUser.getFirstName().length()==0
			||theUser.getLastName() == null || theUser.getLastName().length()==0
			||theUser.getPassword() == null || theUser.getPassword().length()==0
			||theUser.getEmail() == null || theUser.getEmail().length()==0
			||theUser.getUsername() == null || theUser.getUsername().length()==0){
			throw new DataBaseException("field is empty");
		} else try {
			User dbUser = new User();
			dbUser.setFirstName(theUser.getFirstName());
			dbUser.setLastName(theUser.getLastName());
			dbUser.setPassword(theUser.getPassword());
			dbUser.setEmail(theUser.getEmail());
			dbUser.setUsername(theUser.getUsername());
			this.userServiceDao.saveUser(dbUser);
		}catch (ConstraintViolationException exc){
			String hem=exc.getCause().getMessage();

			throw new DataBaseException(hem);
		}
	}


	

}
