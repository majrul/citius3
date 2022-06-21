package com.citiustech.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerServiceExceptionHandler {

	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<ErrorObj> handle(CustomerServiceException e) {
		//other exception handling routine here
		//like logging/email etc..
		ErrorObj obj = new ErrorObj();
		obj.setErrorCode(123); //some superficial error code
		obj.setErrorMessage(e.getMessage());
		obj.setTime(LocalTime.now());

		return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
	}
}

class ErrorObj {
	
	private int errorCode;
	private String errorMessage;
	private LocalTime time;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
}