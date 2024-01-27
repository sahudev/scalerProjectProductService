package com.springdemo.project1.exceptions;


public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message){
        super(message);
    }
}