package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @GetMapping
    public String getVendor() {
        return "GET Vendor";
    }

    @PostMapping
    public String createVendor() {
        return "POST Vendor";
    }

    @PutMapping("/{id}")
    public String updateVendor(@PathVariable Long id) {
        return "PUT Vendor " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteVendor(@PathVariable Long id) {
        return "DELETE Vendor " + id;
    }
}
