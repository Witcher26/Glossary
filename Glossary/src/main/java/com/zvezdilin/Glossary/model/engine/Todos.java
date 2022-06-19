package com.zvezdilin.Glossary.model.engine;

public class Todos {
    private final StorageOfWord storage;

    public Todos(StorageOfWord storage) {
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
