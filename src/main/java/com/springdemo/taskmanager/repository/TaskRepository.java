package com.springdemo.taskmanager.repository;

import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.entity.TaskStatus;
import com.springdemo.taskmanager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}