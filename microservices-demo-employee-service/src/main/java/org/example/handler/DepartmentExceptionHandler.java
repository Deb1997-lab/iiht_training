package org.example.handler;

import org.example.exception.DepartmentNotFoundException;
import org.example.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleDepartmentNotFoundException(DepartmentNotFoundException e){
		ErrorResponseModel error = new ErrorResponseModel();
		error.setErrorTime(System.currentTimeMillis());
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
