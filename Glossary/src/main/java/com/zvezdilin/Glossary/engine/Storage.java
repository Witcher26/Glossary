package com.zvezdilin.Glossary.engine;

/**
 * interface Storage - задает логику добавления/удаления слов в хранилище, а также вывод всех слов.
 */
public interface Storage {
    /**
     * метод добавления слова в хранилище Repository
     *
     * @param word      - добавляемое слово
     * @param translate - перевод
     * @param locale    - метка о принадлежности языка, see {@link com.zvezdilin.Glossary.model.config.Locale}
     * @return true or false
     */
    boolean addWord(String word, String translate, String locale);

    /**
     * метод удаления слова из хранилища Repository
     *
     * @param words - удаляемое слово
     * @return true or false
     */
    boolean removeWord(String words);

    /**
     * метод получения всех слов из хранилище Repository. Слова выводятся в алфавитном порядке (реализован компаратор)
     *
     * @return строку StringBuilder, содержащую через запятую слова с переводом.
     */
    String getAllWords();
}