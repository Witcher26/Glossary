package com.zvezdilin.Glossary.model.exeptionClass;

public class BadDataException extends Exception {
    public BadDataException(String str) {
        super("Некорректные данные для ввода. " + str);
    }
}
