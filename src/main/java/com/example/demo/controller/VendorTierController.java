package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-tier")
public class VendorTierController {

    @GetMapping
    public String tier() {
        return "Vendor Tier API Working";
    }
}
