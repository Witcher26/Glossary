package com.zvezdilin.Glossary.engineApi;

public class Todos {
    private final Storage storage;

    public Todos(Storage storage) {
        this.storage = storage;
    }

    public void addWord(String word, String translate, String locale) {
        storage.addWord(word, translate, locale);
    }

    public void removeWord(String word) {
        storage.removeWord(word);
    }

    public String getAllWords() {
        return storage.getAllWords();
    }
}
