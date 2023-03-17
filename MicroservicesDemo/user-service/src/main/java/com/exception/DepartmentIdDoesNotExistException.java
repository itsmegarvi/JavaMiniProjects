package com.exception;


public class DepartmentIdDoesNotExistException extends Exception {
    public DepartmentIdDoesNotExistException(String msg){
        super(msg);
    }
}
