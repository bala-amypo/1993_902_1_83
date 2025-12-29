package com.example.demo.repository;

import com.example.demo.model.VendorPerformanceScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorPerformanceScoreRepository
        extends JpaRepository<VendorPerformanceScore, Long> {

    /**
     * IMPORTANT:
     * - Tests mock this exact method name
     * - Derived query FAILS for Vendor vs Long
     * - JPQL FIXES IT
     */
    @Query("""
        SELECT vps
        FROM VendorPerformanceScore vps
        WHERE vps.vendor.id = :vendorId
        ORDER BY vps.calculatedAt DESC
    """)
    List<VendorPerformanceScore>
    findByVendorOrderByCalculatedAtDesc(@Param("vendorId") Long vendorId);
}
