package com.utkarshsenpai.taskservice.service;

import com.utkarshsenpai.taskservice.model.Task;
import com.utkarshsenpai.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
    public Task updateTask(Task updatedTask, Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDeadline(updatedTask.getDeadline());
            task.setUpdatedAt(Instant.now());
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
