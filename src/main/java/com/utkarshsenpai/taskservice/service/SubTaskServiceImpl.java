package com.utkarshsenpai.taskservice.service;

import com.utkarshsenpai.taskservice.model.SubTask;
import com.utkarshsenpai.taskservice.model.dto.SubTaskDto;
import com.utkarshsenpai.taskservice.repository.SubTaskRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    private SubTaskRepository subTaskRepository;
    public SubTaskServiceImpl(SubTaskRepository subTaskRepository){
        this.subTaskRepository = subTaskRepository;
    }
    @Override
    public List<SubTask> getAllSubTask() {
        return subTaskRepository.findAll();
    }

    @Override
    public SubTask getSubTaskById(Long id) {
        return subTaskRepository.findById(id).orElse(null);
    }

    @Override
    public SubTask updateSubTask(SubTaskDto updatedSubTaskDto, Long id) {
        Optional<SubTask> subTaskOptional = subTaskRepository.findById(id);
        if (subTaskOptional.isPresent()){
            SubTask subTask = subTaskOptional.get();
            subTask.setTitle(updatedSubTaskDto.getTitle());
            subTask.setDescription(updatedSubTaskDto.getDescription());
            subTask.setStartTime(updatedSubTaskDto.getStartTime());
            subTask.setEndTime(updatedSubTaskDto.getEndTime());
            subTask.setUpdatedAt(Instant.now());
            subTask.setTask(updatedSubTaskDto.getTask());
            return subTaskRepository.save(subTask);
        }
        else{
            return null;
        }
    }

    @Override
    public SubTask addSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    @Override
    public String deleteSubTask(Long id) {
        if (subTaskRepository.existsById(id)){
            subTaskRepository.deleteById(id);
            return "SubTask deleted successfully.";
        }
        else{
            return null;
        }
    }
}
