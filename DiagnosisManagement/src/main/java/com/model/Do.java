package com.model;

import com.exception.InvalidTestNameException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Do {
    private Diagnosis dg;

    public void validatetest(String str) throws InvalidTestNameException {
        if(!dg.getTestkits().containsKey(str)){
            throw new InvalidTestNameException("The given Test doesn't exist");
        }
    }

    public double getprice(String str){
        return dg.getTestkits().get(str);
    }
}
