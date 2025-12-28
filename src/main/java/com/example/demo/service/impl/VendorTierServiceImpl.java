package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;
import org.springframework.stereotype.Service;

@Service
public class VendorTierServiceImpl implements VendorTierService {

    private final VendorTierRepository vendorTierRepository;

    public VendorTierServiceImpl(VendorTierRepository vendorTierRepository) {
        this.vendorTierRepository = vendorTierRepository;
    }

    @Override
    public VendorTier createTier(VendorTier tier) {

        if (tier.getMinScoreThreshold() < 0 ||
            tier.getMinScoreThreshold() > 100) {
            throw new IllegalArgumentException("Threshold must be between 0–100");
        }

        if (vendorTierRepository.existsByTierName(tier.getTierName())) {
            throw new IllegalArgumentException("Tier name must be unique");
        }

        return vendorTierRepository.save(tier);
    }

    @Override
    public void deactivateTier(Long id) {

        VendorTier tier = vendorTierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tier not found"));

        tier.setActive(false);
        vendorTierRepository.save(tier);
    }
}
