package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

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

public class Main2_client_check_normal_job {

    public static void main(String[] args) throws InterruptedException { //TODO в тесты добавить мокирование, имитирующее ответ работу client + server + База Данных PostgresQL
        MySingletonLogger logger = MySingletonLogger.getLogger();
//        Language unit = Client.createNewWord("Unit", "единица измерения", Type.EN);

//        String wordToJsonToServer = Client.languageToJson(unit);
//        System.out.println(wordToJsonToServer);

        Map<String, Language> storage = new HashMap<>();
        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
        Todos todos = new Todos(adapter);
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();

        logger.getInfo("Выполнение точки входа. Старт программы");


//        Language wordFromClient = TodoServer.jsonToEnglishLanguage(wordToJsonToServer);
//        System.out.println("Вывод объекта класса English");
//        System.out.println(wordFromClient.toString());



        logger.getInfo("Logger start: ");
        String s = "{ \"type\": \"ADD\", \"task\": \"{\\\"id\\\":0,\\\"word\\\":\\\"Unit\\\",\\\"translation\\\":\\\"единица измерения\\\",\\\"priority\\\":\\\"LOW\\\"}\" }";
        logger.getInfo("так выглядит строка в консоле:" + s);

//        logger.getInfo("Отправка на сервер команды об удалении слова unit");
//        s =Client.makeRequestToRemoveWord("unit");

        logger.getInfo("Отправка на сервер команды о выведе всех слов в консоль");
        s= Client.makeRequestToGetAllTasks();


        JsonElement rootNode = JsonParser.parseString(s);
        logger.getInfo("получение rootNode при парсинге: " + rootNode.toString());

        JsonObject details = rootNode.getAsJsonObject();
        logger.getInfo("получение details при парсинге: " + details.toString());

        String type = details.get("type").getAsString();
        logger.getInfo("получение type: " + type);

        String languageInJson = details.get("task").getAsString();
        logger.getInfo("получение task: " + languageInJson);


//        String st = Client.makeRequestToAddNewWord(languageInJson);
//        logger.getInfo("Получилось слово: " + st);




        switch (type) {
            case "ADD":
                Language language = TodoServer.jsonToEnglishLanguage(languageInJson);//TODO преобразовываем строки json в объект language, надо проверять
                logger.getInfo("создание экземпляра Language в условном операторе switch" + language.toString());

                todos.addTask(language);  //TODO преобразование в объект, надо смотреть JSON, надо проверять
                logger.getInfo("добавление в хранилище через addTAsk" + todos.getAllTasks());

                System.out.println("Добавлено слово: " + language.getWord());
                break;
            case ("REMOVE"):
                todos.removeTask(" "); //TODO преобразование в объект, через JSON, надо проверять
                break;
            case ("GETALLTASKS"):
                todos.getAllTasks();
                break;
        }
    }
}

