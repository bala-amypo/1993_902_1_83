package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private final VendorPerformanceScoreRepository scoreRepo;
    private final DeliveryEvaluationRepository evalRepo;
    private final VendorRepository vendorRepo;
    private final VendorTierRepository tierRepo;

    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository scoreRepo,
            DeliveryEvaluationRepository evalRepo,
            VendorRepository vendorRepo,
            VendorTierRepository tierRepo) {
        this.scoreRepo = scoreRepo;
        this.evalRepo = evalRepo;
        this.vendorRepo = vendorRepo;
        this.tierRepo = tierRepo;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        List<DeliveryEvaluation> evaluations =
                evalRepo.findByVendorId(vendorId);

        if (evaluations.isEmpty()) {
            return scoreRepo.save(
                    new VendorPerformanceScore(vendor, 0.0, 0.0, 0.0));
        }

        long onTime = evaluations.stream()
                .filter(e -> Boolean.TRUE.equals(e.getMeetsDeliveryTarget()))
                .count();

        long quality = evaluations.stream()
                .filter(e -> Boolean.TRUE.equals(e.getMeetsQualityTarget()))
                .count();

        double onTimePct = (onTime * 100.0) / evaluations.size();
        double qualityPct = (quality * 100.0) / evaluations.size();
        double overall = (onTimePct + qualityPct) / 2;

        VendorPerformanceScore score =
                new VendorPerformanceScore(vendor, onTimePct, qualityPct, overall);

        return scoreRepo.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        List<VendorPerformanceScore> list =
                scoreRepo.findByVendor_IdOrderByCalculatedAtDesc(vendorId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return scoreRepo.findByVendor_IdOrderByCalculatedAtDesc(vendorId);
    }
}
