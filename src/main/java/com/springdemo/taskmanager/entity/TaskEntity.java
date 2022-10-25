package com.springdemo.taskmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;
    @Column(name = "content")
    private String content;

    @Column(name = "taskstatus")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    public TaskEntity(UUID id, String content, TaskStatus taskStatus) {
        this.id = id;
        this.content = content;
        this.taskStatus = taskStatus;
    }
}
