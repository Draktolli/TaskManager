package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.DashboardEntity;
import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.model.TaskModel;
import com.springdemo.taskmanager.repository.DashboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final DashboardRepository dashboardRepository;
    public TaskEntity modelToEntity (TaskModel model){
        DashboardEntity dashboard = Optional.ofNullable(model.dashboard_id())
                .map(dashboardID -> dashboardRepository
                        .findById(dashboardID)
                        .orElseThrow(() -> new IllegalArgumentException("Dashboard with name " + model.dashboard_id() + " not found"))).get();
        return new TaskEntity(model.id(), dashboard, model.content(), model.taskStatus());
    }
    public TaskModel EntityToModel(TaskEntity entity){
        return new TaskModel(entity.getId(), entity.getDashboard().getId(), entity.getContent(), entity.getTaskStatus());
    }
}
