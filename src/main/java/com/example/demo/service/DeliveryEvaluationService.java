package com.example.demo.service;

import com.example.demo.model.DeliveryEvaluation;
import java.util.List;

public interface DeliveryEvaluationService {

    List<DeliveryEvaluation> getAllEvaluations();

    DeliveryEvaluation saveEvaluation(DeliveryEvaluation evaluation);
}
