package ru.zvezdilin.javacore.myPetProject.todos.interfaces;

public interface ILogger {
    /**
     * Логировоние на участках выполнения программы. Данные экземпляр, также как и хранилище тасков, должно быть одним
     * на всю программу, поэтому будет реалзиовано через паттерн Singleton
     *
     */
    void append(String str);
}
