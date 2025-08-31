package com.utkarshsenpai.taskservice.controller;

import com.utkarshsenpai.taskservice.model.SubTask;
import com.utkarshsenpai.taskservice.model.dto.SubTaskDto;
import com.utkarshsenpai.taskservice.service.SubTaskService;
import com.utkarshsenpai.taskservice.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class SubTaskController {
    private SubTaskService subTaskService;
    private TaskService taskService;
    public SubTaskController(SubTaskService subTaskService,TaskService taskService){
        this.subTaskService = subTaskService;
        this.taskService = taskService;
    }
    @RequestMapping(value = "/sub-task",method = RequestMethod.GET)
    public ResponseEntity<List<SubTask>> getAllSubTask(){
        return new ResponseEntity<>(subTaskService.getAllSubTask(),HttpStatus.OK );
    }
    @RequestMapping(value = "/sub-task/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubTask> getSubTask(@PathVariable Long id){
        SubTask subTask = subTaskService.getSubTaskById(id);
        if ( subTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subTask,HttpStatus.OK);
    }
    @RequestMapping(value = "/sub-task",method = RequestMethod.POST)
    public ResponseEntity<SubTask> addSubTask(@RequestBody SubTaskDto subTaskDto){
        if (taskService.getTaskById(subTaskDto.getTask().getId()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        SubTask subTask = new SubTask();
        subTask.setTitle(subTaskDto.getTitle());
        subTask.setDescription(subTaskDto.getDescription());
        subTask.setStartTime(subTaskDto.getStartTime());
        subTask.setEndTime(subTaskDto.getEndTime());
        subTask.setCreatedAt(Instant.now());
        subTask.setUpdatedAt(Instant.now());
        subTask.setTask(subTaskDto.getTask());
        return new ResponseEntity<>(subTaskService.addSubTask(subTask),HttpStatus.CREATED);
    }
    @RequestMapping(value = "/sub-task/{id}",method = RequestMethod.PUT)
    public ResponseEntity<SubTask> updateSubTask(@RequestBody SubTaskDto subTaskDto, @PathVariable Long id){
        SubTask subTask = subTaskService.updateSubTask(subTaskDto,id);
        if (subTask == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(subTask, HttpStatus.CREATED);
        }
    }
    @RequestMapping(value = "/sub-task/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteSubTask(@PathVariable Long id){
        String deleteResponse = subTaskService.deleteSubTask(id);
        if (deleteResponse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
