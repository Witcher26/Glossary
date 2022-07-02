package com.zvezdilin.Glossary.engine;

/**
 * interface Storage - задает логику работы с хранилищем GlobalRepository.
 */
public interface Storage {
    /**
     * метод добавления слова
     *
     * @param word      - добавляемое слово
     * @param translate - перевод
     * @param locale    - метка о принадлежности языка, see {@link com.zvezdilin.Glossary.model.config.Locale}
     * @return true or false
     */
    boolean addWord(String word, String translate, String locale);

    /**
     * метод удаления слова
     *
     * @param words - удаляемое слово
     * @return true or false
     */
    boolean removeWord(String words);

    /**
     * метод получения всех слов. Слова выводятся в алфавитном порядке (реализован компаратор)
     *
     * @return StringBuilder, содержащий через запятую слово и перевод.
     */
    String getAllWords();
}