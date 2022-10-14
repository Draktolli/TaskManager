package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.TaskEtity;
import com.springdemo.taskmanager.model.TaskModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {
    public TaskEtity modelToEntity (TaskModel model){
        return new TaskEtity(model.id(), model.content(), model.taskStatus());
    }
    public TaskModel EntityToModel(TaskEtity taskEtity){
        return new TaskModel(taskEtity.getId(), taskEtity.getContent(), taskEtity.getTaskStatus());
    }
}
