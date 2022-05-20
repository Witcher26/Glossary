package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

public class Todos {

    private final IStorage storage;

    public Todos(IStorage storage) {
        this.storage = storage;
    }

    public void addTask(Language task) {
        storage.addTask(task);
    }

    public void removeTask(Language task) {
        storage.removeTask(task);
    }

    public String getAllTasks() {
        return storage.getAllTasks();
    }
}
