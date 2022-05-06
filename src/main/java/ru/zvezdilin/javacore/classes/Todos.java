package ru.zvezdilin.javacore.classes;

import ru.zvezdilin.javacore.interfaces.IStorage;

import java.util.*;

public class Todos  {

    protected final IStorage storage;

    public Todos(IStorage storage) {
        this.storage = storage;
    }

    public void addTask(String task) {
        storage.addTask(task);
    }

    public void removeTask(String task) {
        storage.removeTask(task);
    }

    public String getAllTasks() {
        return storage.getAllTasks();
    }

}
