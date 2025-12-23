package com.example.demo.service;

import com.example.demo.model.DeliveryEvaluation;
import java.util.List;

public interface DeliveryEvaluationService {

    DeliveryEvaluation saveEvaluation(DeliveryEvaluation evaluation);

    List<DeliveryEvaluation> getAllEvaluations();

    DeliveryEvaluation getEvaluationById(Long id);

    void deleteEvaluation(Long id);
}
