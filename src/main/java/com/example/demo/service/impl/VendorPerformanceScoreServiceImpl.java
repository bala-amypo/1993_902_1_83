package com.example.demo.service.impl;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.repository.VendorPerformanceScoreRepository;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private final VendorPerformanceScoreRepository repository;

    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorPerformanceScore saveScore(VendorPerformanceScore score) {
        return repository.save(score);
    }

    @Override
    public List<VendorPerformanceScore> getAllScores() {
        return repository.findAll();
    }

    @Override
    public VendorPerformanceScore getScoreById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteScore(Long id) {
        repository.deleteById(id);
    }
}
