package ru.zvezdilin.javacore.myPetProject.todos.exeptionClass;

public class BadDataException extends Exception {
    public BadDataException(String str) {
        super("Некорректные данные для ввода, ошибка " + str);
    }
}
