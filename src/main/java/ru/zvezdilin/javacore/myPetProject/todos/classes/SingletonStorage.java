package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;


public class SingletonStorage {
    private static SingletonStorage singletonStorage;
    protected static IStorage storage;

    private SingletonStorage(IStorage storage) {
        this.storage = storage;
    }

    public static synchronized SingletonStorage getStorageInstance() throws NullPointerException {
        //TODO прописание исключительной ситуации
        return singletonStorage;
    }


    public static synchronized SingletonStorage createStorageInstance(IStorage storage) {
        if (singletonStorage == null) {
            System.out.println("Хранилище создано.");
            singletonStorage = new SingletonStorage(storage);
        } else {
            System.out.println("Хранилище было создано ранее. Создать новое не удалось.");
        }
        return singletonStorage;
    }
}


