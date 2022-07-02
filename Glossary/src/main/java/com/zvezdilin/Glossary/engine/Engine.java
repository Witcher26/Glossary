package com.zvezdilin.Glossary.engine;

import com.google.gson.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/engine/v1/")
public class Engine {

    public Engine() {
    }

    Logger LOGGER = Logger.getLogger(Engine.class.getName());
    String translation = "";
    String locale = "";
    String word = "";

    @PostMapping("start")
    public String start(@RequestBody String requestFromClientInJson) {
        String result = "empty str";

        LOGGER.log(Level.INFO, "Start engine server...");
        StorageConnector connector = new StorageConnector();

        JsonElement rootNode = JsonParser.parseString(requestFromClientInJson);
        LOGGER.log(Level.INFO, "Получен rootNode при парсинге: " + rootNode.toString());

        JsonObject details = rootNode.getAsJsonObject();
        LOGGER.log(Level.INFO, "Получены details при парсинге: " + details.toString());

        String target = details.get("target").getAsString();
        LOGGER.log(Level.INFO, "Получен target: " + target);

        if (target.equals("ADD")) {
            word = details.get("word").getAsString();
            LOGGER.log(Level.INFO, "Получен word: " + word);

            translation = details.get("translation").getAsString();
            LOGGER.log(Level.INFO, "Получен translation: " + translation);

            locale = details.get("locale").getAsString();
            LOGGER.log(Level.INFO, "получен locale: " + locale);
        }

        if (target.equals("REMOVE")) {
            word = details.get("word").getAsString();
            LOGGER.log(Level.INFO, "получен word: " + word);
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
            LOGGER.log(Level.WARNING, "Ошибка в engine в switch/case");
            e.printStackTrace();
        }
        return result;
    }
}
