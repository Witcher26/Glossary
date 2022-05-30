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
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Type;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) { //TODO в тесты добавить мокирование, имитирующее ответ работу client + server + База Данных PostgresQL
        MySingletonLogger logger = MySingletonLogger.getLogger();

        Map<String, Language> storage = new HashMap<>();
        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
        Todos todos = new Todos(adapter);
        TodoServer server = new TodoServer(8989, todos);
        server.start();

        logger.getInfo("Выполнение точки входа. Старт программы");

    }

}



