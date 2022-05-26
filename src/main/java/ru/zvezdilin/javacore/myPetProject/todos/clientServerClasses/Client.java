package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
import ru.zvezdilin.javacore.myPetProject.todos.loggerClass.MySingletonLogger;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {
    private static final String welcome = "Hello men. Welcome to my first Pet-Project. It's called a dictionary ";//TODO заменить
    private static final String messFromServ = "Message from Server: "; //TODO заменить другой фигней

    public static void main(String[] args) {
        MySingletonLogger logger = MySingletonLogger.getLogger();
        logger.getInfo("Старт на клиенте");

        try {
            try (Socket clientSocket = new Socket("localhost", 8989);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                logger.getInfo("Вывод в консоль сообщения с номером порта %s " + clientSocket.getPort());
                System.out.printf("Подключение к серверу с портом %s ", clientSocket.getPort() + "\n");

                String word = Integer.toString(clientSocket.getPort());

                out.write(word + "\n"); // ШАГ 1: посылка первого сообщения на сервер
                out.flush();
                logger.getInfo("Отправка номера порта на сервер: " + word);
                Thread.sleep(1000); // ШАГ 3: синхронизация

                logger.getInfo("Приём сообщения от сервера об удачном подключении:");
                System.out.println(messFromServ + in.readLine()); // ШАГ 5: приём сообщения от сервера
                Thread.sleep(1000); //  ШАГ 6: синхронизация

                logger.getInfo("Получение сообщения от сервера о написании имени:");
                System.out.println(messFromServ + in.readLine()); //ШАГ 8: приём сообщения


                //шаг 9 -отправка объекта

                //TODO обернуть в метод
                Language unit = new English("Unit", "единица измерения");
                String wordToJson = languageToJson(unit);
                Thread.sleep(1000);

                String sb = "{ \"type\": \"ADD\", \"task\": \"" + wordToJson + "\" }";

                out.write(sb);
                out.flush();
                logger.getInfo("Отправка на сервер Language unit в json-строке - " + unit);

            }

        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
    }

    public static String languageToJson(Language language) { //TODO не переводит в json TIMELOCADATE
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(language);
    }
}
