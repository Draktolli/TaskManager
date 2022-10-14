package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.entity.TaskStatus;
import com.springdemo.taskmanager.model.TaskModel;
import com.springdemo.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    public List<TaskModel> getAllTasks() {
        List<TaskModel> modelList = new ArrayList<>();
        List<TaskEtity> taskEtities = taskRepository.findAll();
        for (TaskEtity task :
                taskEtities) {
            modelList.add(taskMapper.EntityToModel(task));
        }
        return modelList;
    }
    public TaskModel getTaskByID(UUID id) {
        return taskMapper.EntityToModel(taskRepository.findById(id).get());
    }
    @Transactional
    public TaskModel createTask(TaskModel taskModel) {
        TaskEtity taskEtity;
        try {
            taskEtity = taskMapper.modelToEntity(taskModel);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return taskMapper.EntityToModel(taskRepository.save(taskEtity));
    }
    public void deleteTaskById (UUID id) {taskRepository.deleteById(id);}

    public TaskModel updateTask(UUID id, TaskStatus taskStatus) {
        TaskEtity task = taskRepository.findById(id).get();
        task.setTaskStatus(taskStatus);
        return taskMapper.EntityToModel(taskRepository.save(task));
    }

}
