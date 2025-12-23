package com.example.demo.service;

import com.example.demo.model.SLARequirement;
import java.util.List;

public interface SLARequirementService {

    SLARequirement saveRequirement(SLARequirement requirement);

    List<SLARequirement> getAllRequirements();

    SLARequirement getRequirementById(Long id);

    void deleteRequirement(Long id);
}
