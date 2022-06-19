package com.zvezdilin.Glossary.model.engine;

import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@RestController // без этой аннотации не работает
@RequestMapping("api/storage")
public class TodosLanguageStorageConnector implements Storage {
    private static TodosLanguageStorageConnector connector;
    private static Map<String, Language> wordsMap;

    Logger logger = Logger.getLogger("TodosLanguageStorageConnector class");

    private TodosLanguageStorageConnector() {

    }

    public static synchronized TodosLanguageStorageConnector getConnector() {
        if (connector == null) {
            connector = new TodosLanguageStorageConnector();
            wordsMap = new HashMap<>();
        }
        return connector;
    }

    @PostMapping("addWord")
    @Override
    public void addWord(@RequestParam("word") String word, @RequestParam("translate") String translate, @RequestParam("locale") String locale) {
        Language newWord = null;

        if (word == null || translate == null) {
            logger.warning("NullPointerException при создании слова");
            throw new NullPointerException("Слово или перевод имеют значение null");
        }

        if (locale.contains("EN")) {
            newWord = new English(word, translate);
        }

        assert newWord != null;
        String strToLowCase = newWord.getWord().toLowerCase();

        if (wordsMap.containsKey(strToLowCase)) {
            logger.warning("Данное слово уже присутствует в словаре");

        } else {
            wordsMap.put(strToLowCase, newWord);
            logger.info("Слово " + newWord.getWord() + " успешно добавлено в словарь");
        }
    }

    @PostMapping("removeWord")
    @Override
    public void removeWord(@RequestParam("wordToRemove") String wordToRemove) {
        if (wordToRemove == null) {
            logger.warning("в метод \"removeWord\" не передали слово для удаления");
            throw new NullPointerException("Слово имеет значение null");
        }
        String strToLowCase = wordToRemove.toLowerCase();
        if (wordsMap.containsKey(strToLowCase)) {
            System.out.println("Слово " + strToLowCase + " удалено");
            wordsMap.remove(strToLowCase);
        } else {
            logger.warning("Нет совпадений");
        }
    }


//    @Override
//    public int compare(StringBuilder st1, StringBuilder st2){
//        return st1.toString().compareTo(st2.toString());
//    }


    @GetMapping("getAllWords")
    @Override
    public String getAllWords() {
        if (wordsMap.isEmpty()) {
            logger.warning("Слова отсутствуют в списке");
            return "Слова отсутствуют в списке";
        }

        StringBuilder sb = new StringBuilder();

        //TODO реализовать comparator для лексико-графического вывода слов
        for (Map.Entry<String, Language> entry : wordsMap.entrySet()) {
            sb.append(entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
