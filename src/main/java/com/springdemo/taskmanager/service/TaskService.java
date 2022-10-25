package com.springdemo.taskmanager.service;

import com.springdemo.taskmanager.entity.TaskEntity;
import com.springdemo.taskmanager.entity.TaskStatus;
import com.springdemo.taskmanager.model.TaskModel;
import com.springdemo.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskModel> getAllTasks() {

        List<TaskModel> modelList = new ArrayList<>();
        List<TaskEntity> taskEtities = taskRepository.findAll();

        for (TaskEntity task : taskEtities) {

            modelList.add(taskMapper.EntityToModel(task));

        }

        return modelList;
    }

    public TaskModel getTaskByID(UUID id) throws Exception {

        Optional<TaskEntity> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            throw new Exception();
        }

        return taskMapper.EntityToModel(task.get());
    }

    @Transactional
    public TaskModel createTask(TaskModel taskModel) {

        TaskEntity taskEntity;

        try {

            taskEntity = taskMapper.modelToEntity(taskModel);

            final TaskEntity createdTask = taskRepository.save(taskEntity);

            return taskMapper.EntityToModel(createdTask);

        } catch (IllegalArgumentException e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void deleteTaskById(UUID id) {
        taskRepository.deleteById(id);
    }

    public TaskModel updateTask(UUID id, TaskStatus taskStatus) {

        TaskEntity task = taskRepository.findById(id).get();

        task.setTaskStatus(taskStatus);

        task = taskRepository.save(task);

        return taskMapper.EntityToModel(task);
    }

}
