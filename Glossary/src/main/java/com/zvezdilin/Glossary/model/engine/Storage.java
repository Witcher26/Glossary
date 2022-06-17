package com.zvezdilin.Glossary.model.engine;

public interface Storage {
    /**
     * Добавление слов в хранилище. Хралище должно быть в одном
     * экземпляре(паттерн Singleton).
     */
    void addWord(String word, String translate, String locale);

    /**
     *Удаление слов из хранилища. При отсутствии - вывод сообщения или своего собственного искл.
     */

    void removeWord(String word);

    /**
     * Вывод всех слов (даже если список пустой - сообщение об этом).
     * @return собранную строку (посредством SB)
     */

    String getAllWords();
};