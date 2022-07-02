package com.zvezdilin.Glossary.model.entity;

import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.config.Priority;
import com.zvezdilin.Glossary.model.exeptionClass.BadDataException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Language implements BaseEntity {
    protected int id;
    protected String localDateTime;
    protected Locale locale;
    protected String word;
    protected String translation;
    protected Priority priority;
    protected String type;

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
        this.id = hashCode(); //TODO устанавливается
        this.localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME).toString();  //TODO устанавливается
        this.word = word;
        this.translation = translation;
        this.type = this.getClass().toString();
        this.priority = Priority.LOW;  //TODO устанавливается
    }

    public Language(int id, String localDateTime, String locale, String word, String translation, String priority, String type) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.locale = Locale.valueOf(locale);
        this.word = word;
        this.translation = translation;
        this.priority = Priority.getValue(priority);
        this.type = type;
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

    /**
     * метод проверки принадлежности к языку, see {@link com.zvezdilin.Glossary.model.config.LanguageHelper}
     * Для каждого языка задаётся отдельное регулярное выражение
     *
     * @param word - проверяемое на принадлежность к языку слово
     * @return true or false
     */
    public abstract boolean isAlphabet(String word);

    /**
     * метод проверки слова при редактировании
     *
     * @param word - редактируемое слово
     * @return true or false
     * @throws BadDataException при несоответствии локали и вводе недопустимых символов
     */
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
}



