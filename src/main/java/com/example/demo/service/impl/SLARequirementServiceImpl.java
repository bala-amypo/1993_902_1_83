package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SLARequirement> getAllRequirements() {
        return repository.findAll();
    }

    @Override
    public SLARequirement saveRequirement(SLARequirement requirement) {
        return repository.save(requirement);
    }
}
