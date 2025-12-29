package com.example.demo.controller;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-scores")
public class VendorPerformanceScoreController {

    private final VendorPerformanceScoreService service;

    public VendorPerformanceScoreController(
            VendorPerformanceScoreService service) {
        this.service = service;
    }

    @GetMapping("/{vendorId}")
    public List<VendorPerformanceScore>
    getScores(@PathVariable Long vendorId) {
        return service.getScoresByVendor(vendorId);
    }
}
