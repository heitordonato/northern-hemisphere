package com.heitordonato.northernhemisphere.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.heitordonato.northernhemisphere.core.exception.IpNotFoundException;
import com.heitordonato.northernhemisphere.core.exception.WrongNumberOfIpException;

/**
 * @author Heitor Donato
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IpNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){

        return new ResponseEntity<Object>("Ip Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({WrongNumberOfIpException.class})
    public ResponseEntity<Object> handleWrongNumberOfIpException(Exception exception, WebRequest request){

        return new ResponseEntity<Object>("Wrong Number of Ip", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    
    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException exception, WebRequest request){

        return new ResponseEntity<Object>("Ip Vigilante Error", new HttpHeaders(), exception.getStatusCode());
    }
}