package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.DashboardEntity;
import com.springdemo.taskmanager.model.DashboardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DashboardMapper {
    private final TaskMapper taskMapper;

    public DashboardEntity modelToEntity(DashboardModel dashboard){
        return new DashboardEntity(dashboard.id(), dashboard.name(), dashboard.tasks().stream().map(taskMapper::modelToEntity).toList());
    }
    public DashboardModel entityToModel(DashboardEntity entity){
        return new DashboardModel(entity.getId(), entity.getName(), Optional.ofNullable(entity.getTasks()).stream().flatMap(Collection::stream).map(taskMapper::EntityToModel).toList());
    }

}
