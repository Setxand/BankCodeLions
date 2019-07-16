package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired AuthService authService;

	@PostMapping("/login")
	public void login(@RequestBody LoginRequest request) {
		authService.login(request);
	}

	@PostMapping("/signup")
	public void signUp(@RequestBody LoginRequest request) {
		authService.signUp(request);
	}

}
