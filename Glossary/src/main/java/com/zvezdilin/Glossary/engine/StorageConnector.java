package com.zvezdilin.Glossary.engine;

import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController // без этой аннотации не работает
@RequestMapping("api/storage")
public class StorageConnector implements Storage {
//    protected  StorageConnector connector;
    protected Map<String, Language> wordsMap;

    Logger LOGGER = Logger.getLogger(StorageConnector.class.getName());

    public StorageConnector() {
//        connector = new StorageConnector();
        wordsMap = GlobalRepository.getRepository().getWordsMap();
    }

//    public static synchronized StorageConnector getConnector() {
//        if (connector == null) {
//            connector = new StorageConnector();
//            wordsMap = GlobalRepository.getRepository().getWordsMap();
//        }
//        return connector;
//    }

    @PostMapping("addWord")  //TODO отсюда убрать @PostMapping
    @Override
    public boolean addWord(@RequestParam("word") String word, @RequestParam("translate") String translate, @RequestParam("locale") String locale) {
        Language newWord = null;

        if (word == null || translate == null) {
            LOGGER.log(Level.WARNING,
                    "NullPointerException при создании слова");
            throw new NullPointerException("Слово или перевод имеют значение null");
        }

        if (locale.equalsIgnoreCase("EN")) {
            newWord = new English(word, translate);
        }

        assert newWord != null;
        String strToLowCase = newWord.getWord().toLowerCase();

        if (wordsMap.containsKey(strToLowCase)) {
            LOGGER.log(Level.WARNING,
                    "Данное слово уже присутствует в словаре");
            return false;

        } else {
            wordsMap.put(strToLowCase, newWord);
            LOGGER.log(Level.INFO,
                    "Слово " + newWord.getWord() + " успешно добавлено в словарь");
            return true;
        }
    }

    @PostMapping("removeWord")
    @Override
    public boolean removeWord(@RequestParam("wordToRemove") String wordToRemove) {
        if (wordToRemove == null) {
            LOGGER.log(Level.WARNING,
                    "В метод \"removeWord\" передан null");
            throw new NullPointerException("Слово имеет значение null");
        }
        String strToLowCase = wordToRemove.toLowerCase();
        if (wordsMap.containsKey(strToLowCase)) {
            LOGGER.log(Level.INFO,
                    "Слово " + strToLowCase + " удалено");
            wordsMap.remove(strToLowCase);
            return true;
        } else {
            LOGGER.log(Level.WARNING,
                    "Совпадений не найдено");
            return false;
        }
    }

    @GetMapping("getAllWords")
    @Override
    public String getAllWords() {
        if (wordsMap.isEmpty()) {
            LOGGER.log(Level.WARNING,
                    "Репозиторий пуст");
            return "Репозиторий пуст";
        }

        StringBuilder sb = new StringBuilder();

        //TODO реализовать comparator для лексико-графического вывода слов
        for (Map.Entry<String, Language> entry : wordsMap.entrySet()) {
            sb.append(entry.getValue() + "\n");
        }
        return sb.toString();
    }

    //TODO на удаление
//    public List<BaseEntity> listBaseEntity() {
//        List<BaseEntity> list = new ArrayList<>();
//        for (Map.Entry<String, Language> entry : wordsMap.entrySet()) {
//            list.add(entry.getValue());
//        }
//        return list;
//    }
//
//    public void addBaseEntity(BaseEntity baseEntity) {
//        Language language = (Language) baseEntity;
//        if (!wordsMap.containsKey(language.getWord())) {
//            wordsMap.put(language.getWord(), language);
//        }
//    }
}
