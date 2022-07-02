package com.zvezdilin.Glossary.model.config;

/**
 * Класс приоритетов слов
 */
public enum Priority {
    LOW, MEDIUM, HIGH;

    /**
     * метод установления приоритета у слова.
     *
     * @param str - передаваемый приоритет слову. При отсутствии совпадений - устанавливает Low-приоритет
     * @return по умалчанию Priority.Low
     */
    public static Priority getValue(String str) {
        if (str.equalsIgnoreCase("MEDIUM")) {
            return Priority.MEDIUM;
        }
        if (str.equalsIgnoreCase("HIGH")) {
            return Priority.HIGH;
        }
        return Priority.LOW;
    }
}
