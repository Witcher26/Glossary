package com.zvezdilin.Glossary.model.entity;

import com.zvezdilin.Glossary.model.config.LanguageHelper;
import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.config.Priority;
import com.zvezdilin.Glossary.model.exeptionClass.BadDataException;

import java.util.logging.Logger;

public class English extends Language {
    Logger logger = Logger.getLogger("English class");

    public English() {
    }

    public English(String word, String translation) {
        super(word, translation);
        this.locale = Locale.EN;
    }

    public English(String localDateTime, Locale locale, String word, String translation, Priority priority) {
        super(localDateTime, locale, word,translation, priority);
    }

    @Override
    public boolean isAlphabet(String name) {
        return name.matches(LanguageHelper.ENGLISHLang.getValue());
    }

    @Override
    protected boolean checkEditWord(String word) throws BadDataException {
        if (word.isEmpty()) {
            logger.warning("word is null");
            throw new NullPointerException("word is null");
        } else if (!isAlphabet(word)) {
            logger.warning("Не допустимые символы при редактировании слова");
            throw new BadDataException("Допустимы символы: \"a-zA-Zа-яА-Я\"");
        } else {
            return true;
        }
    }
}

//    String[] words = text.split("\\P{IsAlphabetic}+"); //алфавитные символы