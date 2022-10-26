package com.springdemo.taskmanager.controller;

import com.springdemo.taskmanager.entity.TaskStatusDTO;
import com.springdemo.taskmanager.model.TaskModel;
import com.springdemo.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{id}")
    public TaskModel getTaskById(@PathVariable UUID id) throws Exception {
        return taskService.getTaskByID(id);
    }

    @PostMapping("/task")
    public TaskModel createTask(@RequestBody TaskModel task) {
        return taskService.createTask(task);
    }

    @GetMapping("/task")
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping(value = "/task/{id}")
    public TaskModel updateTask(@PathVariable("id") UUID id, @RequestBody TaskStatusDTO taskStatus) {
        return taskService.updateTask(id, taskStatus.getTaskStatus());
    }

}
