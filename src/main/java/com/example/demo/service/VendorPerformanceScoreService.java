package com.example.demo.service;

import com.example.demo.model.VendorPerformanceScore;
import java.util.List;

public interface VendorPerformanceScoreService {

    VendorPerformanceScore saveScore(VendorPerformanceScore score);

    List<VendorPerformanceScore> getAllScores();

    VendorPerformanceScore getScoreById(Long id);

    void deleteScore(Long id);
}
