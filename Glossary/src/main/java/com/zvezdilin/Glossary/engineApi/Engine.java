package com.zvezdilin.Glossary.engineApi;

import com.google.gson.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/engine/v1/")
public class Engine {

    public Engine() {
    }

    Logger logger = Logger.getLogger("Engine class");
    String translation = "";
    String locale = "";
    String word = "";

    @PostMapping("start")
    public String start(@RequestBody String requestFromClientInJson) {
        String result = "empty str";

        logger.info("Start engine server...");
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        JsonElement rootNode = JsonParser.parseString(requestFromClientInJson);
        logger.info("получение rootNode при парсинге: " + rootNode.toString());

        JsonObject details = rootNode.getAsJsonObject();
        logger.info("получение details при парсинге: " + details.toString());

        String target = details.get("target").getAsString();
        logger.info("получение target: " + target);

        if (target.equals("ADD")) {
            word = details.get("word").getAsString();
            logger.info("получение word: " + word);

            translation = details.get("translation").getAsString();
            logger.info("получение translation: " + translation);

            locale = details.get("locale").getAsString();
            logger.info("получение locale: " + locale);
        }

        if (target.equals("REMOVE")) {
            word = details.get("word").getAsString();
            logger.info("получение word: " + word);
        }

        try {
            switch (target) {
                case "ADD":
                    boolean tmp = connector.addWord(word, translation, locale);
                    result = String.valueOf(tmp);
                    break;
                case ("REMOVE"):
                    tmp = connector.removeWord(word);
                    result = String.valueOf(tmp);
                    break;
                case ("GETALLTASKS"):
                    result = "список всех слов: \n" + connector.getAllWords();
                    break;
                default:
                    result = "Неверный синтаксис запроса";
            }
        } catch (Exception e) {
            logger.warning("Ошибка в engine в switch/case");
        }
        return result;
    }
}
