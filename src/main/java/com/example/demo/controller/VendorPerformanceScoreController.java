package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-performance")
public class VendorPerformanceScoreController {

    @GetMapping
    public String getScore() {
        return "GET Vendor Performance";
    }

    @PostMapping
    public String createScore() {
        return "POST Vendor Performance";
    }

    @PutMapping("/{id}")
    public String updateScore(@PathVariable Long id) {
        return "PUT Vendor Performance " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteScore(@PathVariable Long id) {
        return "DELETE Vendor Performance " + id;
    }
}
