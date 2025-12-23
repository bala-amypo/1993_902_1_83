package com.example.demo.service;

import com.example.demo.model.VendorTier;
import java.util.List;

public interface VendorTierService {

    VendorTier saveVendorTier(VendorTier vendorTier);

    List<VendorTier> getAllVendorTiers();

    VendorTier getVendorTierById(Long id);

    void deleteVendorTier(Long id);
}
