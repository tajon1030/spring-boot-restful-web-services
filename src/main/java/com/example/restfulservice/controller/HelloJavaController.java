package com.example.restfulservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloJavaController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "HelloWorld";
    }
}
