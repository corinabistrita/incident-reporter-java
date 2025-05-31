package org.example.Model;

import java.time.LocalDate;

public class Incident {
    private int incident_id;
    private String incident;
    private String status;
    private String description;
    private String priority;
    private LocalDate created_at;

    public Incident(){

    }

    public int getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(int incident_id) {
        this.incident_id = incident_id;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Incident(int incident_id, String incident, String status, String priority, String description, LocalDate created_at) {
        this.incident_id = incident_id;
        this.incident = incident;
        this.status = status;
        this.priority = priority;
        this.description = description;
        this.created_at = created_at;
    }
}
