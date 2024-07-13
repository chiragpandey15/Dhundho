package com.example.dhundho.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;



@EntityScan
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CaseStatus status;

    // Constructors, getters, and setters

    public Case() {
    }

    public Case(String name, String description, CaseStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Case(Long caseId, String string, String string2, CaseStatus open) {
        //TODO Auto-generated constructor stub
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }
}
