package com.example.demo.controller;

import com.example.demo.model.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    @PostMapping
    public SLARequirement create(@RequestBody SLARequirement sla) {
        return service.createRequirement(sla);
    }

    @PutMapping("/{id}")
    public SLARequirement update(
            @PathVariable Long id,
            @RequestBody SLARequirement sla) {
        return service.updateRequirement(id, sla);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRequirement(id);
    }
}
