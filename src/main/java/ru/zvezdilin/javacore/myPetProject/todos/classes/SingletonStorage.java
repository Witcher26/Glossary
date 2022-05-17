package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;

import java.util.ArrayList;
import java.util.List;

public final class SingletonStorage {
    private static SingletonStorage singletonStorage;
    private static IStorage storage;

    private SingletonStorage(IStorage storage) {
        this.storage = storage;
    }

    public static synchronized SingletonStorage getStorageInstance() {
        if (singletonStorage == null) {
            List<String> storage = new ArrayList<>();
            TodosStorageAdapter adapter = new TodosStorageAdapter(storage);
            singletonStorage = new SingletonStorage(adapter);
        }
        return singletonStorage;
    }
}


