package com.springdemo.project1.controlleradvices;

import com.springdemo.project1.dtos.ExceptionDTO;
import com.springdemo.project1.exceptions.ProductNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.print.PrintException;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handlerArithmeticException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
    }
}