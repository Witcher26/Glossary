package ru.zvezdilin.javacore.myPetProject.todos.languageObjects;

import ru.zvezdilin.javacore.myPetProject.todos.exeptionClass.BadDataException;

public class English extends Language {

    public English(String word, String translation) {
        super(word, translation);
    }

    @Override
    public void editWord(String word) throws BadDataException {

        if (word.isEmpty()) {
            throw new NullPointerException("word is null");
        } else if (!isAlpha(word)) {
            throw new BadDataException("this is not a word");
        } else {
            this.word = word;
        }
    }

    @Override
    public void editTranslation(String translation) throws BadDataException {

        if (translation.isEmpty()) {
            throw new NullPointerException("word is null");
        } else if (!isAlpha(translation)) {
            throw new BadDataException("this is not a word");
        } else {
            this.translation = translation;
        }
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
}


//    String split = ("\\P{IsAlphabetic}+");