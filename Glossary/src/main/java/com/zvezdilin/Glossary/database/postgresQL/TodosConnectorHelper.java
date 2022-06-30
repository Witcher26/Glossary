package com.zvezdilin.Glossary.database.postgresQL;

import com.zvezdilin.Glossary.engine.Todos;
import com.zvezdilin.Glossary.engine.TodosConnector;
import com.zvezdilin.Glossary.model.entity.Language;

import java.util.Map;

public class TodosConnectorHelper extends TodosConnector {
    private TodosConnector connector;

    public TodosConnectorHelper() {
        if(connector==null){
            connector = TodosConnector.getConnector();
        }
    }

    public  Map<String, Language> getWordsMapFromConnector() {
        Map<String, Language> wordsMap;
        return wordsMap = TodosConnector.wordsMap;
    }
}