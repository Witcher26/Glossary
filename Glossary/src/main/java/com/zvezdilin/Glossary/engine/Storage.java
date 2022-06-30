package com.zvezdilin.Glossary.engine;

public interface Storage {
    boolean addWord(String word, String translate, String locale);

    boolean removeWord(String word);

    String getAllWords();
};