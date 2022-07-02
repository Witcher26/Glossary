package com.zvezdilin.Glossary.database.postgresQL;

import com.zvezdilin.Glossary.engine.StorageConnector;
import com.zvezdilin.Glossary.model.entity.Language;

import java.util.Map;

public class StorageConnectorHelper extends StorageConnector {
    private StorageConnector connector;

    public StorageConnectorHelper() {
        if (connector == null) {
            connector = StorageConnector.getConnector();
        }
    }

    public Map<String, Language> getWordsMapFromConnector() {
        Map<String, Language> wordsMap;
        return wordsMap = StorageConnector.wordsMap;
    }
}
