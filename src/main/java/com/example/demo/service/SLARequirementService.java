package com.example.demo.service;

import com.example.demo.model.SLARequirement;
import java.util.List;

public interface SLARequirementService {

    List<SLARequirement> getAllRequirements();

    SLARequirement saveRequirement(SLARequirement requirement);
}
