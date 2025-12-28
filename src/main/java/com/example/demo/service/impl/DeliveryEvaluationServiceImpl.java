package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evaluationRepo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo) {
        this.evaluationRepo = evaluationRepo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        Vendor vendor = vendorRepo.findById(eval.getVendor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        if (!vendor.getActive())
    throw new IllegalStateException("active vendors");

if (eval.getActualDeliveryDays() < 0)
    throw new IllegalArgumentException(">= 0");

if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100)
    throw new IllegalArgumentException("between 0 and 100");


        SLARequirement sla = slaRepo.findById(eval.getSlaRequirement().getId())
                .orElseThrow(() -> new IllegalArgumentException("SLA not found"));

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays());

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getQualityThreshold());

        return evaluationRepo.save(eval);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return evaluationRepo.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long slaId) {
        return evaluationRepo.findBySlaRequirementId(slaId);
    }
}
