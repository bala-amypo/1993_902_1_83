package com.example.demo.service;

import com.example.demo.model.VendorTier;
import java.util.List;

public interface VendorTierService {

    List<VendorTier> getAllTiers();

    VendorTier saveTier(VendorTier tier);
}
