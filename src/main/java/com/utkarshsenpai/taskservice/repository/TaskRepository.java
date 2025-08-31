package com.utkarshsenpai.taskservice.repository;

import com.utkarshsenpai.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
