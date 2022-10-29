package com.example.camlist.controllers.exceptions;

import com.example.camlist.exceptions.ResourceIsAlreadyExistException;
import com.example.camlist.exceptions.ResourceNotExistException;
import com.example.camlist.exceptions.ResourceSaveException;
import com.example.camlist.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	  @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<StandardError> productHasAlreadyBeenSold(UserNotFoundException e, HttpServletRequest request) {

	        StandardError err = new StandardError(new Date(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	    }

	@ExceptionHandler(ResourceSaveException.class)
	public ResponseEntity<StandardError> userSaveException(ResourceSaveException e, HttpServletRequest request) {

		StandardError err = new StandardError(new Date(), HttpStatus.BAD_REQUEST.value(),  e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(ResourceIsAlreadyExistException.class)
	public ResponseEntity<StandardError> tagIsExistException(ResourceIsAlreadyExistException e, HttpServletRequest request) {

		StandardError err = new StandardError(new Date(), HttpStatus.BAD_REQUEST.value(),  e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(ResourceNotExistException.class)
	public ResponseEntity<StandardError> resourceNotExistExceptionHandler(ResourceNotExistException e, HttpServletRequest request) {

		StandardError err = new StandardError(new Date(), HttpStatus.NOT_FOUND.value(),  e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
