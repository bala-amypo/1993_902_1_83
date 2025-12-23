package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sla-requirement")
public class SLARequirementController {

    @GetMapping
    public String sla() {
        return "SLA Requirement API Working";
    }
}
