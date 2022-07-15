package com.zvezdilin.Glossary.engine;

import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Hidden
@Tag(name = "storage", description = "не клиентский endpoint для работы со storage connector")
@RestController
@RequestMapping("api/storage")
public class StorageConnector implements Storage {
    protected Map<String, Language> wordsMap;

    Logger LOGGER = Logger.getLogger(StorageConnector.class.getName());

    public StorageConnector() {
        wordsMap = GlobalRepository.getRepository().getWordsMap();
    }

    @PostMapping("addWord")
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

        List<Language> valueList = new ArrayList<>(wordsMap.values());
        valueList.sort(new Comparator<Language>() {
            @Override
            public int compare(Language o1, Language o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        });

        for (Language o : valueList) {
            sb.append(o).append("\n");
        }

        return sb.toString();
    }
}
