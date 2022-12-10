package com.e_com.controller;

import com.e_com.exception_handler.DataBaseException;
import com.e_com.exception_handler.ExceptionMessage;
import com.e_com.exception_handler.UserException;
import com.e_com.rest_class.RestUser;
import com.e_com.sevice.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.e_com.Entity.JwtRequest;
import com.e_com.Entity.JwtResponse;
import com.e_com.sevice.CustomUserDetailService;
import com.e_com.utility.JwtUtil;

import java.util.Date;

/**
 * @author Hemant Sing Yadav
 */
@RestController
@CrossOrigin
@RequestMapping("/api/public")
public class LoginSignupController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtutil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> genratedToken(@RequestBody JwtRequest jwtRequest) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new UserException("User not found exception");

        }
        UserDetails userDetails = this.customUserDetailService.
                loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtutil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signup")
    public void signupForUser(@RequestBody RestUser theUser) {
        if (theUser.getFirstName() == null || theUser.getFirstName().length() == 0
                || theUser.getLastName() == null || theUser.getLastName().length() == 0
                || theUser.getPassword() == null || theUser.getPassword().length() == 0
                || theUser.getEmail() == null || theUser.getEmail().length() == 0
                || theUser.getUsername() == null || theUser.getUsername().length() == 0) {
            throw new DataBaseException("field are empty");
        } else {
            try {
                this.userService.saveUser(theUser);
            } catch (ConstraintViolationException exc) {
                String hem = exc.getCause().getMessage();
                throw new DataBaseException(hem);
            }
        }
    }

    @PostMapping("/username/{theUsername}")
    public ExceptionMessage isUsernameExist(@PathVariable String theUsername) {
        if (theUsername != null) {
            if (this.userService.isUsernamePresent(theUsername)) {
                return new ExceptionMessage(
                        201,
                        "Username already present",
                        (long) new Date().getTime());
            } else {
                return new ExceptionMessage(
                        200,
                        "Username available",
                        (long) new Date().getTime());
            }
        } else {
            return new ExceptionMessage(
                    202,
                    "Username is empty",
                    (long) new Date().getTime());
        }
    }

}
