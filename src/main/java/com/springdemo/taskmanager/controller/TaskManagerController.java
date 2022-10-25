package com.springdemo.taskmanager.controller;

import com.springdemo.taskmanager.entity.TaskStatus;
import com.springdemo.taskmanager.entity.TaskStatusDTO;
import com.springdemo.taskmanager.model.TaskModel;
import com.springdemo.taskmanager.service.TaskService;
import jdk.jfr.ContentType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class TaskManagerController {

    private final TaskService taskService;

    public TaskManagerController(TaskService taskService) {
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
