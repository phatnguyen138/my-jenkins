package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class MyController {
//    @Value("${my_var.var1}")
//    @Autowired
//    private String myname;
    @GetMapping("/hello")
    public ResponseEntity<?> helloGet(){
        return ResponseEntity.ok().body("Hello Devops ");
    }
}
