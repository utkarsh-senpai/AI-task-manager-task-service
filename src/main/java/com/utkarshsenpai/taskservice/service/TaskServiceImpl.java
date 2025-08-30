package com.utkarshsenpai.taskservice.service;

import com.utkarshsenpai.taskservice.model.Task;
import com.utkarshsenpai.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> getTasks(){
        return taskRepository.findAll();

    }
    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    @Override
    public Task updateTask(Task task, Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return taskRepository.save(task);
        }
        else {
            return null;
        }
    }
    @Override
    public Task addTask(Task task){
        return taskRepository.save(task);
    }
    @Override
    public String deleteTask(Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return "Task Deleted successfully.";
        }
        else {
            return null;
        }
    }
}
