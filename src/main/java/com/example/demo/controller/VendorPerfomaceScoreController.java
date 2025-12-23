package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-performance")
public class VendorPerformanceScoreController {

    @GetMapping
    public String score() {
        return "Vendor Performance Score API Working";
    }
}
