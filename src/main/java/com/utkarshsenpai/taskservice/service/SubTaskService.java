package com.utkarshsenpai.taskservice.service;

import com.utkarshsenpai.taskservice.model.SubTask;
import com.utkarshsenpai.taskservice.model.dto.SubTaskDto;

import java.util.List;

public interface SubTaskService {
    List<SubTask> getAllSubTask();
    SubTask getSubTaskById(Long id);
    SubTask updateSubTask(SubTaskDto subTaskDto, Long id);
    SubTask addSubTask(SubTask subTask);
    String deleteSubTask(Long id);
}
