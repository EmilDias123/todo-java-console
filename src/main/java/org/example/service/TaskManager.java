package org.example.service;

import org.example.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks;
    private int nextId;

    public TaskManager(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
        this.nextId = tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }

    public void addTask(String title, LocalDate deadline) {
        Task task = new Task(nextId++, title, deadline, false);
        tasks.add(task);
        System.out.println("Добавлено!\n");
    }

    public void listTasks() {// вывести список
        if (tasks.isEmpty()) {
            System.out.println("Список задач пустой.\n");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println();
    }

    public void markDone(int id) {//отметить задание
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDone(true);
                System.out.println("Задача отмечена как выполненная\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Задачи с таким id не существует\n");
        }
    }

    public void deleteTask(int id) {//удалить задание
        Task toRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                toRemove = task;
                break;
            }
        }
        if (toRemove != null) {
            tasks.remove(toRemove);
            System.out.println("Задача удалена\n");
        } else {
            System.out.println("Задачи с таким id не существует\n");
        }

    }

    public List<Task> getTasks(){ //вывести список для сохранения
        return tasks;
    }

}
