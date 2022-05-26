package ru.zvezdilin.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosLanguageStorageAdapter;
import ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses.Client;
import ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses.TodoServer;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {

    public static void main(String[] args) { //TODO в тесты добавить мокирование, имитирующее ответ работу client + server + База Данных PostgresQL

//        Language unit = new English("Unit", "единица измерения");
//        String wordToJsonToServer = Client.languageToJson(unit);
//        System.out.println(wordToJsonToServer);

        Map<String, Language> storage = new HashMap<>();
        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
        Todos todos = new Todos(adapter);
        TodoServer server = new TodoServer(8989, todos);
        server.start();
        MySingletonLogger logger = MySingletonLogger.getLogger();
        logger.append("Старт на сервере");

//        Language wordFromClient= TodoServer.jsonToEnglishLanguage(wordToJsonToServer);
//        System.out.println("Вывод объекта класса English");
//        System.out.println(wordFromClient.toString());

    }
}
