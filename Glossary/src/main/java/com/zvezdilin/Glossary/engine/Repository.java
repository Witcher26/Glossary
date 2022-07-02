package com.zvezdilin.Glossary.engine;

import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class Repository - singleton класс для работы с хранилищем в режиме "одного окна".
 */
public class Repository {
    private Storage storage;
    protected static Repository repository;
    protected static Map<String, Language> wordsMap;

    private static final Logger LOGGER = Logger.getLogger(Repository.class.getName());

    public Repository(Storage storage) {  //TODO лишний конструктор
        this.storage = storage;
    }

    private Repository() {
    }

    /**
     * метод возвращает хранилище слов Repository
     */
    public static synchronized Repository getRepository() {
        if (repository == null) {
            repository = new Repository();
            wordsMap = new HashMap<>();
        }
        return repository;
    }

    public Map<String, Language> getWordsMap() {
        return wordsMap;
    }

    public List<BaseEntity> getListBaseEntity() {
        List<BaseEntity> list = new ArrayList<>();
        if (wordsMap.isEmpty()) {
            LOGGER.log(Level.INFO,
                    "repository is null");
        }
        for (Map.Entry<String, Language> entry : wordsMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public void addBaseEntity(BaseEntity baseEntity) { //TODO возможно сделать метод boolean
        Language language = (Language) baseEntity;
        if (wordsMap.containsKey(language.getWord())) {
            LOGGER.log(Level.INFO,
                    "попытка добавления в repository дубликата");
        }
        wordsMap.put(language.getWord(), language);
    }
}
