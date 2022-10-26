package com.springdemo.taskmanager.controller;

import com.springdemo.taskmanager.model.DashboardModel;
import com.springdemo.taskmanager.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DashboardController {
    private final DashboardService service;

    public DashboardController (DashboardService service){this.service = service;}

    @GetMapping("/dashboard/{id}")
    public DashboardModel getDashboardById(@PathVariable UUID id) throws Exception{
        return service.getDashboardById(id);
    }

    @GetMapping("/dashboard")
    public List<String> getAlllDashboards () {return service.getAllDashboards();}

    @PostMapping("/dashboard")
    public DashboardModel createDashboard (@RequestBody DashboardModel model){ return service.createDashboard(model);}

    @DeleteMapping("/dashboard/{id}")
    public void deleteDashboardd (UUID id) {service.deleteDashboard(id);}
}
