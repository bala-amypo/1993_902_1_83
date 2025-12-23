package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sla_requirements")
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requirementName;
    private String description;

    public SLARequirement() {
    }

    public SLARequirement(Long id, String requirementName, String description) {
        this.id = id;
        this.requirementName = requirementName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
