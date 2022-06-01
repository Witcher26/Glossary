package ru.zvezdilin.javacore.myPetProject.todos.languageObjects;

import ru.zvezdilin.javacore.myPetProject.todos.exeptionClass.BadDataException;

public class English extends Language {

    public English() {
    }

    public English(String word, String translation) {
        super(word, translation);
        this.language = Type.EN;
    }

    @Override
    public boolean isAlphabet(String name) {
        return name.matches("[a-zA-Zа-яА-Я]+"); //TODO добавить match на пробел и знак -
    }

    @Override
    protected String checkEditWord(String word) throws BadDataException {
        if (word.isEmpty()) {
            throw new NullPointerException("word is null");
        } else if (!isAlphabet(word)) {
            throw new BadDataException("допустимы символы: \"a-zA-Zа-яА-Я\"");
        } else {
            return word;
        }
    }
}

//    String[] words = text.split("\\P{IsAlphabetic}+"); //алфавитные символы