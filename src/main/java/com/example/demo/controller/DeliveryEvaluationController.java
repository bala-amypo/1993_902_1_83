package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery-evaluation")
public class DeliveryEvaluationController {

    @GetMapping
    public String getEvaluation() {
        return "GET Delivery Evaluation";
    }

    @PostMapping
    public String createEvaluation() {
        return "POST Delivery Evaluation";
    }

    @PutMapping("/{id}")
    public String updateEvaluation(@PathVariable Long id) {
        return "PUT Delivery Evaluation " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteEvaluation(@PathVariable Long id) {
        return "DELETE Delivery Evaluation " + id;
    }
}
