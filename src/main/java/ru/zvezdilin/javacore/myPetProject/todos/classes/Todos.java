package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;

public class Todos  {

    private final IStorage storage;

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
