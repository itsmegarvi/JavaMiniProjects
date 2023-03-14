package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/hi")
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String hello(){
        return "Hello ladies and gentleman, Welcome to Webservice";
    }
}
