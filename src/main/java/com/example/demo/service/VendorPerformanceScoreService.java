package com.example.demo.service;

import com.example.demo.model.VendorPerformanceScore;
import java.util.List;

public interface VendorPerformanceScoreService {

    List<VendorPerformanceScore> getScoresByVendor(Long vendorId);
}
