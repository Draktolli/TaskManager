package com.springdemo.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TaskStatusDTO {
    @Getter
    @Setter
    @JsonProperty(value = "status")
    private TaskStatus taskStatus;
}
