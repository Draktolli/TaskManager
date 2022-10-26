package com.springdemo.taskmanager.model;

import com.springdemo.taskmanager.entity.TaskStatus;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record TaskModel (
        UUID id,

        UUID dashboard_id,
        @NotBlank String content,
        @NotBlank TaskStatus taskStatus
) { }
