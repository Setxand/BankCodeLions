package com.example.demo.controller;

import com.example.demo.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorResponse handleIllegalArgument(final IllegalArgumentException ex) {
		return new ErrorResponse(ex.getMessage(), "ILLEGAL_ARGUMENT");
	}

}
