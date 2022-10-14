package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.model.TaskModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {
    public TaskEntity modelToEntity (TaskModel model){
        return new TaskEntity(model.id(), model.content(), model.taskStatus());
    }
    public TaskModel EntityToModel(TaskEntity taskEntity){
        return new TaskModel(taskEntity.getId(), taskEntity.getContent(), taskEntity.getTaskStatus());
    }
}
