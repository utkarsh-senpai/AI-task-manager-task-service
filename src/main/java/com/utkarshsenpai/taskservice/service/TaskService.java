package com.utkarshsenpai.taskservice.service;

import com.utkarshsenpai.taskservice.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    Task getTaskById(Long id);
    Task updateTask(Task task, Long id);
    Task addTask(Task task);
    String deleteTask(Long id);
}
