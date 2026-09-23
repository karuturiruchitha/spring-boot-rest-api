package com.api.model;

import java.time.LocalDate;

public class Project {

    private Long id;
    private String name;
    private String description;
    private String status;
    private String clientName;
    private Double budget;
    private Double gmPercent;
    private LocalDate startDate;
    private LocalDate endDate;
    private String createdBy;

    public Project() {}

    public Project(Long id, String name, String description,
                   String status, String clientName, Double budget,
                   Double gmPercent, LocalDate startDate,
                   LocalDate endDate, String createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.clientName = clientName;
        this.budget = budget;
        this.gmPercent = gmPercent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public Double getGmPercent() { return gmPercent; }
    public void setGmPercent(Double gmPercent) { this.gmPercent = gmPercent; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}
