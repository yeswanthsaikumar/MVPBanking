package com.bank.customer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.customer.service.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
	String message = ex.getMessage();
	APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND)
		.build();
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
