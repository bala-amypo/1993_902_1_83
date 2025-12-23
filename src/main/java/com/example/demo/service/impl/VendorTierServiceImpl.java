package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorTierServiceImpl implements VendorTierService {

    private final VendorTierRepository vendorTierRepository;

    public VendorTierServiceImpl(VendorTierRepository vendorTierRepository) {
        this.vendorTierRepository = vendorTierRepository;
    }

    @Override
    public VendorTier saveVendorTier(VendorTier vendorTier) {
        return vendorTierRepository.save(vendorTier);
    }

    @Override
    public List<VendorTier> getAllVendorTiers() {
        return vendorTierRepository.findAll();
    }

    @Override
    public VendorTier getVendorTierById(Long id) {
        return vendorTierRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVendorTier(Long id) {
        vendorTierRepository.deleteById(id);
    }
}
