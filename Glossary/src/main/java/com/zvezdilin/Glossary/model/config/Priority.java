package com.zvezdilin.Glossary.model.config;

/**
 * выставляемый приоритет слов
 * @param {String} str - необходимый приоритет.
 * При отсутствии подходящего устанавливает Low-приоритет
 * @return объект типа Priority
 */
public enum Priority {
    LOW, MEDIUM, HIGH;

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
