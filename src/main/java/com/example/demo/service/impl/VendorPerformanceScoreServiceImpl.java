package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        List<DeliveryEvaluation> evals =
                evalRepo.findByVendorId(vendorId);

        if (evals.isEmpty()) {
            throw new IllegalStateException("No evaluations found");
        }

        long total = evals.size();
        long onTime = evals.stream()
                .filter(DeliveryEvaluation::getMeetsDeliveryTarget)
                .count();
        long quality = evals.stream()
                .filter(DeliveryEvaluation::getMeetsQualityTarget)
                .count();

        double onTimePct = (onTime * 100.0) / total;
        double qualityPct = (quality * 100.0) / total;
        double overall = (onTimePct + qualityPct) / 2;

        VendorPerformanceScore score = new VendorPerformanceScore();
        score.setVendor(vendor);
        score.setCalculatedAt(LocalDateTime.now());
        score.setOnTimePercentage(onTimePct);
        score.setQualityCompliancePercentage(qualityPct);
        score.setOverallScore(overall);

        return scoreRepo.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        List<VendorPerformanceScore> list =
                scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId);

        if (list.isEmpty()) {
            throw new IllegalStateException("No scores available");
        }
        return list.get(0);
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId);
    }
}
