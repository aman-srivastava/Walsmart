package com.aman.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by asriva26 on 04/25/18.
 */

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentId;

    private String status;

    private String notes;

    private Long rank;

    private Long dateAssigned;

    private Long deadline;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public String getStatus() {
        return status;
    }

    public Long getDateAssigned() {
        return dateAssigned;
    }

    public Long getDeadline() {
        return deadline;
    }

    public String getDeadlineFormatted() {
        Date date = new Date(getDeadline());
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getDefault());
        String formatted = format.format(date);
        return formatted;
    }

    public String getDateAssignedFormatted() {
        Date date = new Date(getDateAssigned());
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getDefault());
        String formatted = format.format(date);
        return formatted;
    }

    public String getNotes() {
        return notes;
    }

    public User getUser() {
        return user;
    }

    public Long getRank() {
        return rank;
    }

    public void setDateAssigned(Long dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
