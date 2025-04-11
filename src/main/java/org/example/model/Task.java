package org.example.model;

import java.time.LocalDate;



public class Task {

    private int id;
    private String title;
    private LocalDate deadline;
    private boolean done;

    public Task() {

    }

    public Task(int id, String title, LocalDate deadline, boolean done) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
