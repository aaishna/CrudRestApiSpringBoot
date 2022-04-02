package com.bfm.demo.controllerAdvice;

import com.bfm.demo.Exceptionalhandling.EmptyInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyEx(EmptyInputException e){
        return new ResponseEntity<String>("Input field is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementEx(NoSuchElementException e){
        return new ResponseEntity<String>("No value is present db", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                      HttpHeaders headers, HttpStatus status,
                                                                      WebRequest request){
        return new ResponseEntity<Object>("Please change http method type", HttpStatus.NOT_FOUND);
    }
}
