package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.DashboardEntity;
import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.model.DashboardModel;
import com.springdemo.taskmanager.repository.DashboardRepository;
import com.springdemo.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final DashboardMapper dashboardMapper;

    public List<String> getAllDashboards(){
        return dashboardRepository.findAll().stream().map(DashboardEntity::getName).collect(Collectors.toList());
    }
    public DashboardModel getDashboardById(UUID id){
        return dashboardMapper.entityToModel(dashboardRepository.findById(id).get());
    }
    @Transactional
    public DashboardModel createDashboard (DashboardModel dashboardModel){
        DashboardEntity dashboard = new DashboardEntity(dashboardModel.id(), dashboardModel.name(), new ArrayList<TaskEntity>());
        return dashboardMapper.entityToModel(dashboardRepository.save(dashboard));
    }
    public void deleteDashboard (UUID id){
        dashboardRepository.deleteById(id);
    }
}
