package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @GetMapping
    public String vendor() {
        return "Vendor API Working";
    }
}
