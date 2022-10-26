package com.springdemo.taskmanager.model;

import java.util.List;
import java.util.UUID;

public record DashboardModel (
        UUID id,
        String name,
        List<TaskModel> tasks
){}

