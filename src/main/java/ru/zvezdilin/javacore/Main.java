package ru.zvezdilin.javacore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosLanguageStorageAdapter;
import ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses.Client;
import ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses.TodoServer;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) { //TODO в тесты добавить мокирование, имитирующее ответ работу client + server + База Данных PostgresQL
        MySingletonLogger logger = MySingletonLogger.getLogger();
        Language unit = new English("Unit", "единица измерения");
        String wordToJsonToServer = Client.languageToJson(unit);
        System.out.println(wordToJsonToServer);
//
//        Map<String, Language> storage = new HashMap<>();
//        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
//        Todos todos = new Todos(adapter);
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();
//
//        logger.getInfo("Выполнение точки входа. Старт программы");
//
////        Language wordFromClient= TodoServer.jsonToEnglishLanguage(wordToJsonToServer);
////        System.out.println("Вывод объекта класса English");
////        System.out.println(wordFromClient.toString());


        logger.getInfo("Logger start: ");
        String s = "{ \"type\": \"ADD\", \"task\": \"{\\\"id\\\":0,\\\"word\\\":\\\"Unit\\\",\\\"translation\\\":\\\"единица измерения\\\",\\\"priority\\\":\\\"LOW\\\"}\" }";
//        String s = "{ \"type\": \"ADD\", \"task\": \"id\":0,\"word\":\"Unit\",\"translation\":\"единица измерения\",\"priority\":\"LOW\"}\"";
        JsonElement rootNode = JsonParser.parseString(s);
        logger.getInfo("получение rootNode при парсинге: " + rootNode.toString());

        JsonObject details = rootNode.getAsJsonObject();
        logger.getInfo("получение details при парсинге: " + details.toString());

        String type = details.get("type").getAsString();
        logger.getInfo("получение type: " + type);

        String languageInJson = details.get("task").getAsString();
        logger.getInfo("получение task: " + languageInJson);

        Language l = TodoServer.jsonToEnglishLanguage(languageInJson);
        logger.getInfo(l.toString());
//        {"id":0,"word":"Unit","translation":"единица измерения","priority":"LOW"}
//        {"id":0,"word":"Unit","translation":"единица измерения","priority":"LOW}"

    }
}
