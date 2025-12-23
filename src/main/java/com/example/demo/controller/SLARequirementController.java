package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sla-requirement")
public class SLARequirementController {

    @GetMapping
    public String getRequirement() {
        return "GET SLA Requirement";
    }

    @PostMapping
    public String createRequirement() {
        return "POST SLA Requirement";
    }

    @PutMapping("/{id}")
    public String updateRequirement(@PathVariable Long id) {
        return "PUT SLA Requirement " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteRequirement(@PathVariable Long id) {
        return "DELETE SLA Requirement " + id;
    }
}
