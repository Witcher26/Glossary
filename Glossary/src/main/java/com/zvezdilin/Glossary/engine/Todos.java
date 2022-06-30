package com.zvezdilin.Glossary.engine;

import com.zvezdilin.Glossary.model.entity.Language;

import java.util.Map;

/**
 *  class Todos - абстрактный, экземпляр этого класа нельзя создать
 *
 */
public abstract class Todos {
    private final Storage storage;

    /**
     *  wordsMap - общее хранилище слов, к которому будет обращаться класс  TodosConnector
     *
     */
    public static Map<String, Language> wordsMap;


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

//    /**
//     * Вывод всех слов (даже если список пустой - сообщение об этом).
//     * @return собранную строку (посредством SB)
//     */
//    public String getAllWords() {
//        return storage.getAllWords();
//    }
}
