package com.ashsherlin.todoapp.model;

import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

public class Task {
    private int taskId;
    private String name;
    private boolean status;
    private String notes;
    private LocalDate dateAdded;
    private String tag;

    public Task() {}

    public Task(int taskId, String name, boolean status, String notes, LocalDate dateAdded, String tag) {
        this.taskId = taskId;
        this.name = name;
        this.status = status;
        this.notes = notes;
        this.dateAdded = dateAdded;
        this.tag = tag;
    }

    public int getId() {
        return taskId;
    }

    public void setId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
