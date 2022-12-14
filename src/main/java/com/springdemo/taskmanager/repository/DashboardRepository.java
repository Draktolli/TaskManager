package com.springdemo.taskmanager.repository;

import com.springdemo.taskmanager.entity.DashboardEntity;
import com.springdemo.taskmanager.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity, UUID> {
}
