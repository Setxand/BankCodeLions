package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	private final UserRepository userRepo;

	public AuthService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public void login(LoginRequest request) {

	}

	public void signUp(LoginRequest request) {

	}
}
