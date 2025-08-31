package com.utkarshsenpai.taskservice.model.dto;

import com.utkarshsenpai.taskservice.model.Task;

import java.time.Instant;

public class SubTaskDto {
    private String title;
    private String description;
    private Instant startTime;
    private Instant endTime;
    private Task task;

    public SubTaskDto() {
    }

    public SubTaskDto(String title, String description, Instant startTime, Instant endTime, Task task) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.task = task;
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

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Task getTask() {
        return task;
    }

    public void setTaskId(Task task) {
        this.task = task;
    }
}

