package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-tier")
public class VendorTierController {

    @GetMapping
    public String getTier() {
        return "GET Vendor Tier";
    }

    @PostMapping
    public String createTier() {
        return "POST Vendor Tier";
    }

    @PutMapping("/{id}")
    public String updateTier(@PathVariable Long id) {
        return "PUT Vendor Tier " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteTier(@PathVariable Long id) {
        return "DELETE Vendor Tier " + id;
    }
}
