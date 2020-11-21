package com.example.postgresql;

public class Projects {
    public String project_id;
    public String name;
    public String description;
    public String created_at;
    public boolean status;

    public String getProject_id() {
        return project_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public boolean isStatus() {
        return status;
    }
}
