package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.*;

import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;
    private static final String welcomeMessage = "Hello men. Welcome to my first Pet-Project. It's called a dictionary ";//TODO заменить

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            MySingletonLogger logger = MySingletonLogger.getLogger();
            logger.append("Старт на сервере");

            String word = in.readLine();  //ШАГ 2: ждет 1-е сообщение от сервера
            logger.append("получение от клиента порта");
            System.out.println("Подключен порт с номером: " + word);
            Thread.sleep(1000);// ШАГ 3: синхронизация

            out.write("Подключение к Серверу произошло удачно!" + "\n"); // ШАГ 4: отправка на сервер
            out.flush();
            logger.append("отправка клиенту уведомления об успешном подключении");

            Thread.sleep(1000); //ШАГ 6: синхронизация
                // синхонная точка
            out.write("Write your name" + "\n");  // ШАГ 7: отправка сообщения
            out.flush();
            logger.append("запрос имени у клиента");

            System.out.println(welcomeMessage + in.readLine()); // ШАГ 10: приём сообщения от клиента


//            while (true) {  //TODO прописать условие выполнения бесконечного цикла или метод выхода из цикла

                //TODO ожидание команды со сторны client
//                String requestFromClientInJson = in.readLine();
//                JsonElement rootNode = JsonParser.parseString(word);
//                JsonObject details = rootNode.getAsJsonObject();
//
//
//                String type = details.get("type").getAsString();
//                String languageInJson = details.get("task").getAsString();

//                String stringInJSON = word;
//                Language language = jsonToEnglishLanguage(stringInJSON);
//                System.out.println(language.toString());
//                System.out.println(todos.getAllTasks());



//            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static Language jsonToEnglishLanguage(String json) {  //TODO только для анг. языка, использвоать return gson.fromJson(json,Language.class); не получается
//        Gson gson = new GsonBuilder().create();
//        return gson.fromJson(json, English.class);
//    }
}






//                switch (type) {
//                        case "ADD":
//                        Language language = jsonToLanguage(languageInJson);//TODO преобразовываем строки json в объект language, надо проверять
//                        todos.addTask(language);  //TODO преобразование в объект, надо смотреть JSON, надо проверять
//                        System.out.println("Добавлено слово: " + language.getWord());
//                        break;
//                        case ("REMOVE"):
//                        todos.removeTask(" "); //TODO преобразование в объект, через JSON, надо проверять
//                        break;
//                        case ("getAllTasks"):
//                        todos.getAllTasks();
//                        break;
//default:
//        Language language1 = jsonToLanguage(languageInJson);//
//        todos.addTask(language1);  //TODO преобразование в объект, надо смотреть JSON, надо проверять
//        System.out.println("Добавлено слово: " + language1.getWord());
//        break;
//
////                        System.out.println(languageInJson);
//        }




