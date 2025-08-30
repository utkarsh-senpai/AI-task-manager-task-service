package com.utkarshsenpai.taskservice.controller;

import com.utkarshsenpai.taskservice.model.Task;
import com.utkarshsenpai.taskservice.model.dto.TaskDto;
import com.utkarshsenpai.taskservice.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @RequestMapping(value = "/task",method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTask(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }
    @RequestMapping(value = "/task/{id}",method = RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/task",method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCreatedAt(Instant.now());
        task.setDeadline(taskDto.getDeadline());
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/task/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCreatedAt(Instant.now());
        task.setDeadline(taskDto.getDeadline());
        Task responseTask = taskService.updateTask(task,id);
        if (responseTask == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(responseTask, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable Long id){
        if (taskService.deleteTask(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
