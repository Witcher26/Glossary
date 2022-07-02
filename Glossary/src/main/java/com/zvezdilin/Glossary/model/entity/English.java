package com.zvezdilin.Glossary.model.entity;

import com.zvezdilin.Glossary.model.config.LanguageHelper;
import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.exeptionClass.BadDataException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class English extends Language {
    Logger LOGGER = Logger.getLogger(English.class.getName());

    public English() {
    }

    public English(String word, String translation) {
        super(word, translation);
        this.locale = Locale.valueOf("EN");

    }

    public English(int id, String localDateTime, String locale, String word, String translation, String priority, String type) {
        super(id, localDateTime, locale, word, translation, priority, type);
    }

    @Override
    public boolean isAlphabet(String word) {
        return word.matches(LanguageHelper.ENGLISHLang.getValue());
    }

    @Override
    protected boolean checkEditWord(String word) throws BadDataException {

        if (word.isEmpty()) {
            LOGGER.log(Level.WARNING, "word is null");
            throw new NullPointerException("word is null");
        } else if (!isAlphabet(word)) {
            LOGGER.log(Level.WARNING, "Не допустимые символы при редактировании слова");
            throw new BadDataException("Допустимы символы: \"a-zA-Zа-яА-Я\"");
        } else {
            return true;
        }
    }
}

//    String[] words = text.split("\\P{IsAlphabetic}+"); //алфавитные символы