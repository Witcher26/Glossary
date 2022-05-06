package ru.zvezdilin.javacore.classes;

import ru.zvezdilin.javacore.interfaces.IStorage;

import java.util.List;

public class ListStorageAdapter implements IStorage {
        protected List<String> todosList = SingleStorage.singleStorage.getTodosList();

    public ListStorageAdapter(List<String> todosList) {
        this.todosList = todosList;
    }
    @Override
    public void addTask(String task){
        todosList.add(task);
    }

    void removeTask(String task);

    String getAllTasks();
}
