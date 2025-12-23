package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-tier")
public class VendorTierController {

    private final VendorTierService vendorTierService;

    public VendorTierController(VendorTierService vendorTierService) {
        this.vendorTierService = vendorTierService;
    }

    @GetMapping
    public List<VendorTier> getAllTiers() {
        return vendorTierService.getAllVendorTiers();
    }

    @GetMapping("/{id}")
    public VendorTier getTierById(@PathVariable Long id) {
        return vendorTierService.getVendorTierById(id);
    }

    @PostMapping
    public VendorTier createTier(@RequestBody VendorTier vendorTier) {
        return vendorTierService.saveVendorTier(vendorTier);
    }

    @PutMapping("/{id}")
    public VendorTier updateTier(
            @PathVariable Long id,
            @RequestBody VendorTier vendorTier) {

        vendorTier.setId(id);
        return vendorTierService.saveVendorTier(vendorTier);
    }

    @DeleteMapping("/{id}")
    public void deleteTier(@PathVariable Long id) {
        vendorTierService.deleteVendorTier(id);
    }
}
