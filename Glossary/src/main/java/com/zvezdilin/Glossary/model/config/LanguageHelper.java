package com.zvezdilin.Glossary.model.config;

public enum LanguageHelper {
    ENGLISHLang("[a-zA-Zа-яА-Я '-]+");

    private final String value;

    LanguageHelper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
