package com.zvezdilin.Glossary.model.entity;

import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.config.Priority;
import com.zvezdilin.Glossary.model.exeptionClass.BadDataException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public abstract class Language implements BaseEntity, Comparator<Language> {
    protected int id;
    protected String localDateTime;
    protected Locale locale;
    protected String word;
    protected String translation;
    protected String type;
    protected Priority priority;

    public int getId() {
        return id;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public Locale getLocale() {
        return locale;
    }

    public Language() {
    }

    public Language(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.id = hashCode();
        this.localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME);
        this.type = Language.class.toString();
        this.priority = Priority.LOW;
    }

    public Language(String localDateTime, Locale locale, String word, String translation, Priority priority) {
        this.localDateTime = localDateTime;
        this.locale = locale;
        this.word = word;
        this.translation = translation;
        this.type = Language.class.toString();
        this.priority = priority;
    }

    public String getWord() {
        return this.word;
    }

    public void editWord(String word) throws BadDataException {
        if (checkEditWord(word)) {
            this.word = word;
        }
    }

    public String getTranslation() {
        return this.translation;
    }

    public void editTranslation(String translation) throws BadDataException {
        if (checkEditWord(translation)) {
            this.translation = translation;
        }
    }

    //TODO abstract method isAlphabet(), переопределяется в каждом конкретном классе в зависимости от ракладки
    public abstract boolean isAlphabet(String name);

    //TODO abstract method, переопределяется в каждом конкретном классе в зависимости от isAlphabet()
    protected abstract boolean checkEditWord(String word) throws BadDataException;

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Слово: \"" +
                getWord().toLowerCase() +
                "\", его перевод: \"" +
                getTranslation().toLowerCase() +
                "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return id == language.id &&
                Objects.equals(locale, language.locale) &&
                Objects.equals(word, language.word) &&
                Objects.equals(translation, language.translation) &&
                Objects.equals(type, language.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, word, translation, type);
    }

    @Override
    public int compare(Language o1, Language o2) {
        return o1.getWord().compareTo(o2.getWord());
    }
}



