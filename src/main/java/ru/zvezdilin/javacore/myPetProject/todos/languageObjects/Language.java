package ru.zvezdilin.javacore.myPetProject.todos.languageObjects;

import ru.zvezdilin.javacore.myPetProject.todos.exeptionClass.BadDataException;
import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IToDoSmth;

import java.time.LocalDateTime;

//Todo возможно применить интерфейс ITodoSmth к одному из конкретных классов..либо это будет функция группировка
public abstract class Language implements IToDoSmth {
    private static int GLOBAL_ID = 0;
    private int id;
    private LocalDateTime localDateTime;
    protected static String language;
    protected String word;
    protected String translation;
    protected Priority priority;

    public Language(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.id = GLOBAL_ID++;
        this.localDateTime = LocalDateTime.now();
        this.priority = Priority.LOW;

    }

    public String getWord() {
        return this.word;
    }

    //TODO обстрактный
    public abstract void editWord(String word) throws BadDataException;

    public String getTranslation() {
        return this.translation;
    }

    //TODO обстрактный
    public abstract void editTranslation(String translation) throws BadDataException;

    public Priority getPriority() {
        return this.priority;
    }

    public void settPriority(Priority priority) {
        this.priority = priority;
    }
}

