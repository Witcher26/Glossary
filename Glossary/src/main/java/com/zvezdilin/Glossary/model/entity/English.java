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

    /**
     *
     * @param word
     * @param translation
     */
    public English(String word, String translation) {
        super(word, translation);
        this.locale = Locale.EN;
    }

    public English(String localDateTime, Locale locale, String word, String translation, Priority priority) {
        super(localDateTime, locale, word, translation, priority);
        this.type = "English.class";
    }

    public English(int id, String localDateTime, String word, String translation, String locale, String priority, String type) {
        super(id, localDateTime,word, translation, locale, priority, type );
    }

    /**
     *
     * @param name - Имя
     * @return
     */
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

    @Override
    public String getType() {
        return this.type;
    }

}

//    String[] words = text.split("\\P{IsAlphabetic}+"); //алфавитные символы