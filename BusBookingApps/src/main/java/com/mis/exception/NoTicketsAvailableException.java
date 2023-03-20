package com.mis.exception;

public class NoTicketsAvailableException extends Exception{
    public NoTicketsAvailableException(String msg){
        super(msg);
    }
}
