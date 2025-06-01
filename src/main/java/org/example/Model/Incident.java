package org.example.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Incident {
    private int incident_id;
    private String incident;
    private String status;
    private String description;
    private String priority;
    private String user_id;
    private LocalDate created_at;

    public Incident(int incident_id, String incident, String status, String description, String priority, LocalDate created_at, String user_id) {
        this.incident_id = incident_id;
        this.incident = incident;
        this.status = status;
        this.description = description;
        this.priority = priority;
        this.user_id = user_id;
        this.created_at = created_at;
    }

    public Incident(String title, String status, String description, String priority, LocalDate createdAt, int userId) {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return String.format("\n%-5s %-25s %-15s %-12s %-18s %-5s\n",
                incident_id,incident,status,priority,created_at.toString(),user_id);
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

}
