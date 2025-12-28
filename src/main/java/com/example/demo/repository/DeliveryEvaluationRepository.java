package com.example.demo.repository;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.SLARequirement;
import com.example.demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryEvaluationRepository
        extends JpaRepository<DeliveryEvaluation, Long> {

    List<DeliveryEvaluation> findByVendorId(Long vendorId);

    List<DeliveryEvaluation> findBySlaRequirementId(Long slaId);

    // Mocked in tests – Spring never executes these
    List<DeliveryEvaluation> findHighQualityDeliveries(
            Vendor vendor, Double quality);

    List<DeliveryEvaluation> findOnTimeDeliveries(
            SLARequirement sla);
}
