package org.example.ui;

import org.example.service.TaskManager;
import org.example.storage.FileStorage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class ConsoleUI {
    private final FileStorage fileStorage = new FileStorage();
    private TaskManager taskManager;

    public void run() throws IOException{// Основной цикл while
        System.out.println("Приветствую тебя в TODO! Выбери действие:");

        try {
            taskManager = new TaskManager(fileStorage.load());
            printConsole();
        } catch (Exception e) {
            System.out.println("Ошибка загрузки задач: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (taskManager != null) {
                fileStorage.save(taskManager.getTasks());
            }
            System.out.println("Всего доброго!");
        }

    }

    private void checkSwitch(){

        switch (inputConsole()){
            case "1" ->{
                System.out.println("Введите название задачи");
                String title = inputConsole();
                System.out.println("Введите дедлайн в днях");
                int day = Integer.parseInt(inputConsole());
                LocalDate localDate = LocalDate.now().plusDays(day);
                taskManager.addTask(title,localDate);
                printConsole();
            }

            case "2" ->{
                taskManager.listTasks();
                printConsole();
            }

            case "3" ->{

                System.out.println("Введите id задачи");
                int id = Integer.parseInt(inputConsole());
                taskManager.markDone(id);
                printConsole();
            }

            case "4" ->{
                System.out.println("Введите id задачи");
                int id = Integer.parseInt(inputConsole());
                taskManager.deleteTask(id);
                printConsole();
            }

            case "9" -> {break;}
            default -> { System.out.println("Нет такого действия ввидите снова!"); printConsole();}
        }
    }

    private void printConsole(){
        System.out.println("Выбери действие");
        System.out.println("1 - Добавление новой задачи");
        System.out.println("2 - Показать все задачи");
        System.out.println("3 - Отметить задачу как выполненную");
        System.out.println("4 - Удалить задачу по ID");
        System.out.println("9 - Завершение приложения");
        System.out.println(" ");
        checkSwitch();

    }

    private String inputConsole(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }

}
