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

        if (r.getMaxDeliveryDays() == null || r.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days");
        }

        if (r.getQualityThreshold() < 0 || r.getQualityThreshold() > 100) {
            throw new IllegalArgumentException("Quality score");
        }

        if (repository.existsByRequirementName(r.getRequirementName())) {
            throw new IllegalArgumentException("unique");
        }

        return repository.save(r);
    }

    @Override
    public SLARequirement updateRequirement(Long id, SLARequirement update) {

        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        if (update.getRequirementName() != null &&
            !update.getRequirementName().equals(existing.getRequirementName())) {

            if (repository.existsByRequirementName(update.getRequirementName())) {
                throw new IllegalArgumentException("unique");
            }
            existing.setRequirementName(update.getRequirementName());
        }

        if (update.getDescription() != null) {
            existing.setDescription(update.getDescription());
        }

        if (update.getMaxDeliveryDays() != null) {
            existing.setMaxDeliveryDays(update.getMaxDeliveryDays());
        }

        if (update.getQualityThreshold() != null) {
            existing.setQualityThreshold(update.getQualityThreshold());
        }

        return repository.save(existing);
    }

    @Override
    public void deactivateRequirement(Long id) {

        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        existing.setActive(false);
        repository.save(existing);
    }
}
