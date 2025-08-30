package com.utkarshsenpai.taskservice.model.dto;

import java.time.Instant;

public class TaskDto {

    private String title;
    private String description;
    private Instant deadline;

    public TaskDto() {
    }

    public TaskDto(String title, String description, Instant deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }
}

