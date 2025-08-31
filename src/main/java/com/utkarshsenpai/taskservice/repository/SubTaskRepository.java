package com.utkarshsenpai.taskservice.repository;

import com.utkarshsenpai.taskservice.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask,Long> {
}
