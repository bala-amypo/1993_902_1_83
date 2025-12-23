package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_tiers")
public class VendorTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tierName;
    private String description;

    public VendorTier() {
    }

    public VendorTier(Long id, String tierName, String description) {
        this.id = id;
        this.tierName = tierName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
