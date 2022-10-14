package com.springdemo.taskmanager.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class TaskEtity {

    @Id
    @GeneratedValue
    private UUID id;
    private String content;
    private TaskStatus taskStatus;

    public TaskEtity(UUID id, String content, TaskStatus taskStatus) {
        this.id = id;
        this.content = content;
        this.taskStatus = taskStatus;
    }
}
