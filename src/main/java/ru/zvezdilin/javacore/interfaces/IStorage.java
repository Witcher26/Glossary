package ru.zvezdilin.javacore.interfaces;

public interface IStorage {
    void addTask(String task);

    void removeTask(String task);

    String getAllTasks();
}
