package org.example.handler;

import org.example.exception.RateNotFoundException;
import org.example.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RateExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleRateException(RateNotFoundException e){
		ErrorResponseModel error = new ErrorResponseModel();
		error.setErrorTime(System.currentTimeMillis());
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(404);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
