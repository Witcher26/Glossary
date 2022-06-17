package com.zvezdilin.Glossary.model.config;

//выставляемый приоритет слов при их создании
public enum Priority {
    LOW, MEDIUM, HIGH;

    public static Priority getValue(String str) {
        if (str.equals("MEDIUM")) {
            return Priority.MEDIUM;
        }
        if (str.equals("HIGH")) {
            return Priority.HIGH;
        }
        return Priority.LOW;
    }
}
