package com.zvezdilin.Glossary.engine;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class EngineTests {
    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }


    @Test
    public void testAddEngineMethod() {

        Logger logger = Logger.getLogger("EngineTest class/testAddEngineMethod");
        String translation = "";
        String locale = "";
        String word = "";

        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        String requestFromClientInJson =
                "{ \"target\": \"ADD\", " +
                        "\"word\": \"unit\", " +
                        "\"translation\": \"единица измерения\", " +
                        "\"locale\": \"EN\"" +
                        "}";

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
                    connector.addWord(word, translation, locale);
                    break;
                case ("REMOVE"):
                    connector.removeWord(word);
                    break;
                case ("GETALLTASKS"):
                    connector.getAllWords();
                    break;
            }
        } catch (Exception e) {
            logger.warning("Ошибка в engine в switch/case");
        }
    }

    @Test
    public void testRemoveEngineMethod() {

        Logger logger = Logger.getLogger("EngineTest class/testRemoveEngineMethod");
        String translation = "";
        String locale = "";
        String word = "";

        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();
        connector.addWord("unit", "единица измерения", "EN");
        connector.addWord("summary", "резюмировать", "EN");
        connector.addWord("coalesce", "объединение", "EN");

        String requestFromClientInJson =
                "{ \"target\": \"REMOVE\", " +
                        "\"word\": \"unit\"" +
                        "}";

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
                    connector.addWord(word, translation, locale);
                    break;
                case ("REMOVE"):
                    connector.removeWord(word);
                    break;
                case ("GETALLTASKS"):
                    connector.getAllWords();
                    break;
            }
        } catch (Exception e) {
            logger.warning("Ошибка в engine в switch/case");
        }
    }

    @Test
    public void testGetAllEngineMethod() {

        Logger logger = Logger.getLogger("EngineTest class/testGetAllEngineMethod");
        String translation = "";
        String locale = "";
        String word = "";

        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();
        connector.addWord("unit", "единица измерения", "EN");
        connector.addWord("summary", "резюмировать", "EN");
        connector.addWord("coalesce", "объединение", "EN");

        String requestFromClientInJson =
                "{ \"target\": \"GETALLTASKS\" " +
                        "}";

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
                    connector.addWord(word, translation, locale);
                    break;
                case ("REMOVE"):
                    connector.removeWord(word);
                    break;
                case ("GETALLTASKS"):
                    connector.getAllWords();
                    break;
            }
        } catch (Exception e) {
            logger.warning("Ошибка в engine в switch/case");
        }
    }
}

