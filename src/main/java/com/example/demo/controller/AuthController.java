package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/test")
    public String test() {
        return "Auth GET working";
    }

    @PostMapping("/login")
    public String login() {
        return "Auth POST working";
    }
}
