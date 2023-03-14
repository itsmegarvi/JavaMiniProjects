package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/train")
public class Home {
    @GetMapping("/hi")
    public String getString(){
        return "index";
    }
}
