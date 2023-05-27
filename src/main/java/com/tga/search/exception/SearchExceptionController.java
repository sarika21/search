package com.tga.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SearchExceptionController {
	@ExceptionHandler(value = MovieNotfoundException.class)
	   public ResponseEntity<Object> exception(MovieNotfoundException exception) {
	      return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
	   }
}
