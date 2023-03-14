package com.restcruddemo.exception;

public class InvalidProductIDException extends Exception{
    public InvalidProductIDException(String msg){
        super(msg);
    }
}
