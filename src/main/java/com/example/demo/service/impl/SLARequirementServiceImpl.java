package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;
import org.springframework.stereotype.Service;

@Service
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement createRequirement(SLARequirement r) {

        if (r.getMaxDeliveryDays() == null || r.getMaxDeliveryDays() <= 0)
            throw new IllegalArgumentException("Max delivery days must be greater than 0");

        if (r.getQualityThreshold() < 0 || r.getQualityThreshold() > 100)
            throw new IllegalArgumentException("Quality score must be between 0 and 100");

        if (repository.existsByRequirementName(r.getRequirementName()))
            throw new IllegalArgumentException("Requirement name must be unique");

        return repository.save(r);
    }

    @Override
    public SLARequirement updateRequirement(Long id, SLARequirement update) {
        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Requirement not found"));

        if (update.getRequirementName() != null &&
                repository.existsByRequirementName(update.getRequirementName())) {
            throw new IllegalArgumentException("Requirement name must be unique");
        }

        if (update.getRequirementName() != null)
            existing.setRequirementName(update.getRequirementName());

        return repository.save(existing);
    }

    @Override
    public void deactivateRequirement(Long id) {
        SLARequirement r = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Requirement not found"));
        r.setActive(false);
        repository.save(r);
    }
}
