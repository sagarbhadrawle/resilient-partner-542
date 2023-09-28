package com.sanjeevani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeevani.model.User;
import com.sanjeevani.exception.InvalidUserException;
import com.sanjeevani.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(value = "*")
public class UserController {
	private UserService userService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		log.info("Add a User to database");

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_" + user.getRole().toUpperCase());// ROLE_USER

		User addUser = userService.addUser(user);
		return new ResponseEntity<User>(addUser, HttpStatus.CREATED);
	}



	@GetMapping("/signIn")
	public ResponseEntity<String> getUserById(Authentication auth) throws InvalidUserException {
		System.out.println("Auth");

		User user = userService.getUserByAadharNo(auth.getName());
		return new ResponseEntity<String>(user.getName() + " Logged In Successfully ", HttpStatus.ACCEPTED);
	}

}
