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
        throw new IllegalArgumentException("Max delivery days");

    if (r.getQualityThreshold() < 0 || r.getQualityThreshold() > 100)
        throw new IllegalArgumentException("Quality score");

    if (repository.existsByRequirementName(r.getRequirementName()))
        throw new IllegalArgumentException("unique");

    return repository.save(r);
}
