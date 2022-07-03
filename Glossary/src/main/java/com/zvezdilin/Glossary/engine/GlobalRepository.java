package com.zvezdilin.Glossary.engine;

import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class GlobalRepository - Singleton класс - единственное хранилище слов на всю программу.
 */
public class GlobalRepository {
    private Storage storage;
    protected static GlobalRepository globalRepository;
    protected static Map<String, Language> wordsMap;

    private static final Logger LOGGER = Logger.getLogger(GlobalRepository.class.getName());

    public GlobalRepository(Storage storage) {  //TODO лишний конструктор
        this.storage = storage;
    }

    private GlobalRepository() {
    }

    /**
     * метод возвращает хранилище globalRepository
     */
    public static synchronized GlobalRepository getRepository() {
        if (globalRepository == null) {
            globalRepository = new GlobalRepository();
            wordsMap = new HashMap<>();
        }
        return globalRepository;
    }

    public Map<String, Language> getWordsMap() {
        return wordsMap;
    }

    public List<BaseEntity> getListBaseEntity() {
        List<BaseEntity> list = new ArrayList<>();
        if (wordsMap.isEmpty()) {
            LOGGER.log(Level.INFO,
                    "GlobalRepository is null");
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
                    "Попытка добавления дубликата в GlobalRepository ");
        }
        wordsMap.put(language.getWord(), language);
    }
}
