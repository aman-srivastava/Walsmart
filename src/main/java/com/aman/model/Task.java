package com.aman.model;

import javax.persistence.*;

/**
 * Created by asriva26 on 04/25/18.
 */

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long taskId;

    private String taskName;

    private String taskPriority;

    private Long taskEstimatedTime;

    public Task(String taskName, String taskPriority, Long taskEstimatedTime) {
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.taskEstimatedTime = taskEstimatedTime;
    }

    public Task() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Long getTaskEstimatedTime() {
        return taskEstimatedTime;
    }

    public void setTaskEstimatedTime(Long taskEstimatedTime) {
        this.taskEstimatedTime = taskEstimatedTime;
    }


}

