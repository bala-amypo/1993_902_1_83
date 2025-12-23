package com.example.demo.service.impl;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl
        implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository repository;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeliveryEvaluation> getAllEvaluations() {
        return repository.findAll();
    }

    @Override
    public DeliveryEvaluation saveEvaluation(
            DeliveryEvaluation evaluation) {
        return repository.save(evaluation);
    }
}
