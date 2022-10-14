package com.springdemo.taskmanager.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class TaskEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String content;

    private TaskStatus taskStatus;

    public TaskEntity(UUID id, String content, TaskStatus taskStatus) {
        this.id = id;
        this.content = content;
        this.taskStatus = taskStatus;
    }
}
