package com.todoApp.ToDoApp.todo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

@Id
@GeneratedValue
private int id;
private String user;

@Size(min=5, message="Enter at minimum 5 Charachters")
private String descr;
private LocalDate targetDate;
private boolean done;

public Todo() {
    super();
}

    public Todo(int id, String user, String descr, LocalDate targetDate, boolean done) {
        this.id = id;
        this.user = user;
        this.descr = descr;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
