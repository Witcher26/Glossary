package com.zvezdilin.Glossary.engine;

public class Todos {
    private final Storage storage;


    public Todos(Storage storage) {
        this.storage = storage;
    }

    /**
     * Добавление слов в хранилище. Хралище должно быть в одном
     * экземпляре(паттерн Singleton).
     */
    public void addWord(String word, String translate, String locale) {
        storage.addWord(word, translate, locale);
    }

    /**
     *Удаление слов из хранилища. При отсутствии - вывод сообщения или своего собственного искл.
     */
    public void removeWord(String word) {
        storage.removeWord(word);
    }

    /**
     * Вывод всех слов (даже если список пустой - сообщение об этом).
     * @return собранную строку (посредством SB)
     */
    public String getAllWords() {
        return storage.getAllWords();
    }
}
