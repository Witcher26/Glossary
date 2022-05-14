package ru.zvezdilin.javacore.myPetProject.todos.exeptionClass;

public class BadDateException extends Exception {
    public BadDateException(String str) {
        super("Некорректные данные для ввода, ошибка " + str);
    }
}
