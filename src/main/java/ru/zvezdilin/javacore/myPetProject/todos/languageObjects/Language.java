package ru.zvezdilin.javacore.myPetProject.todos.languageObjects;

import ru.zvezdilin.javacore.myPetProject.todos.exeptionClass.BadDataException;
import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IToDoSmth;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//Todo применить интерфейс IToDoSmth для добавления новых возможностей. В данный момент интерфейс не имеет контрактов
public abstract class Language implements IToDoSmth {
    private static int GLOBAL_ID = 0;  //TODO public заменить на private
    private int id;
    private String localDateTime;
    protected Type language;
    protected String word;
    protected String translation;
    protected Priority priority;

    public Language() {
    }

    public Language(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.id = GLOBAL_ID++;
        this.localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME);
        this.priority = Priority.LOW;
    }

    public String getWord() {
        return this.word;
    }

    public void editWord(String word) throws BadDataException {
        this.word = checkEditWord(word);
    }

    public String getTranslation() {
        return this.translation;
    }

    public void editTranslation(String translation) throws BadDataException {
        this.translation = checkEditWord(translation);
    }

    //TODO abstract method isAlphabet(), переопределяется в каждом конкретном классе в зависимости от ракладки
    public abstract boolean isAlphabet(String name);


    //TODO abstract method, переопределяется в каждом конкретном классе в зависимости от isAlphabet()
    protected abstract String checkEditWord(String word) throws BadDataException;

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Слово: \"" + getWord().toLowerCase() + "\", его перевод: \"" + getTranslation().toLowerCase() + "\"";
    }
}

