package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.*;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Type;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;
    private static final String welcomeMessage = "Welcome to my first Pet-Project. It's called a dictionary.";//TODO заменить

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");
        MySingletonLogger logger = MySingletonLogger.getLogger();
        logger.getInfo("Старт на сервере");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String word = in.readLine();  //ШАГ 2: ждет 1-е сообщение от сервера
            logger.getInfo("получение от клиента номера порта");
            System.out.println("Подключен порт с номером: " + word);
            Thread.sleep(1000);// ШАГ 3: синхронизация

            out.write("Подключение к Серверу произошло удачно!" + "\n"); // ШАГ 4: отправка на сервер
            out.flush();
            logger.getInfo("Отправка клиенту уведомления об успешном подключении");

            Thread.sleep(1000); //ШАГ 6: синхронизация
            // синхонная точка
            out.write("Write your name" + "\n");  // ШАГ 7: отправка сообщения
            out.flush();
            logger.getInfo("запрос имени у клиента");

            String requestFromClientStringInJson = in.readLine();
            logger.getInfo("Получение объекта в формате json: " + requestFromClientStringInJson);
            System.out.println(requestFromClientStringInJson); // ШАГ 10: приём объекта

//            while (true) {  //TODO прописать условие выполнения бесконечного цикла или метод выхода из цикла

            //TODO ожидание команды со сторны client


            JsonElement rootNode = JsonParser.parseString(requestFromClientStringInJson);
            logger.getInfo("получение rootNode при парсинге: " + rootNode.toString());

            JsonObject details = rootNode.getAsJsonObject();
            logger.getInfo("получение details при парсинге: " + details.toString());

            String type = details.get("type").getAsString();
            logger.getInfo("получение type: " + type);

            String languageInJson = details.get("task").getAsString();
            logger.getInfo("получение task: " + languageInJson);


            switch (type) {
                case "ADD":
                    Language language = jsonToEnglishLanguage(languageInJson);// преобразовываем строку json в объект language
                    logger.getInfo("создание экземпляра Language в условном операторе switch: " + language.toString());

                    todos.addTask(language);
                    logger.getInfo("Добавлено слово: " + language.getWord());
                    logger.getInfo("добавление в хранилище через addTAsk, вывод всех: " + todos.getAllTasks());
                    break;

                case ("REMOVE"):
                    todos.removeTask(" "); //удаляем по строке
                    break;

                case ("GETALLTASKS"):
                    todos.getAllTasks();
                    break;
            }
//            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Language jsonToEnglishLanguage(String json) {  //TODO только для анг. языка, использвоать return gson.fromJson(json,Type.class <? extend Language.class>) не получается
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, English.class);

    }
}

//    public static Language createNewWord(String word, String translation, Type type) {
//        Language language = null;
//        if (type == Type.EN) {
//            English english = new English(word, translation);
//            language = english;
//        }
//        return language;
//    }


