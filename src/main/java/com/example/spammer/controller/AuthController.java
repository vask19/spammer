package com.example.spammer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {


    @GetMapping("/auth/login")
    public String getAuthPage(){
        return "auth/login";
    }

}
