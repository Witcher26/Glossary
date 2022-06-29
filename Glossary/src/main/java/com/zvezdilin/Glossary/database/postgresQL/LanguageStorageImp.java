package com.zvezdilin.Glossary.database.postgresQL;

import com.zvezdilin.Glossary.engine.TodosLanguageStorageConnector;
import com.zvezdilin.Glossary.model.entity.Language;

import java.util.Map;

public class LanguageStorageImp extends TodosLanguageStorageConnector {
    private static Map<String, Language> wordsMap;
    private TodosLanguageStorageConnector connector; //TODO под вопросом, нужно ли здесь это пле

    public LanguageStorageImp() {
        if(connector==null){
            connector = TodosLanguageStorageConnector.getConnector();
        }
    }

    public static Map<String, Language> getWordsMap() {
        return wordsMap;
    }
}
