package com.example.springcurdproject;

import com.example.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<UserErrorResponse> userExce
          (UserNotFoundException exce) {
    UserErrorResponse error = new UserErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exce.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler
  public ResponseEntity<UserErrorResponse> userGen
          (Exception exce) {
    UserErrorResponse error = new UserErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exce.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

  }
}
