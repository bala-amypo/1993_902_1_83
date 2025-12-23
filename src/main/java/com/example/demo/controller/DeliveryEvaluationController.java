package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery-evaluation")
public class DeliveryEvaluationController {

    @GetMapping
    public String evaluate() {
        return "Delivery Evaluation API Working";
    }
}
