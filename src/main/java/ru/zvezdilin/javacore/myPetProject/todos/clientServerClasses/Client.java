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

        try {
            try (Socket clientSocket = new Socket("localhost", 8989);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                MySingletonLogger logger = MySingletonLogger.getLogger();
                logger.append("Старт на клиенте");

                System.out.printf("Подключение к серверу с портом %s ", clientSocket.getPort() + "\n");
                logger.append("Вывод в консольк сообещния, что подключение к серверу с портом %s " + clientSocket.getPort() + "\n");


                String word = Integer.toString(clientSocket.getPort());
                logger.append("Получение порта на стороне клиента");
                out.write(word + "\n"); // ШАГ 1: посылка первого сообщения на сервер
                out.flush();
                logger.append("Отправка номера порта на сервер");
                Thread.sleep(1000); // ШАГ 3: синхронизация


                System.out.println(messFromServ + in.readLine()); // ШАГ 5: приём сообщения от сервера
                logger.append("Приём сообщения от сервера: подключение удачно");
                Thread.sleep(1000); //  ШАГ 6: синхронизация

                System.out.println(messFromServ + in.readLine()); //ШАГ 8: приём сообщения
                logger.append("Получение сообщения от сервера - Write your name");

                out.write("Igor"); // шаг 9: отправка сообщени от сервера
                logger.append("Отправка имени Igor на сервер");


//                Language unit = new English("Unit", "единица измерения");
//                String wordToJson = languageToJson(unit);
//                out.write(wordToJson);
//                out.flush();

            }

        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
    }

    public static String languageToJson(Language language) { //TODO не переводит в json TIMELOCAL
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(language);
    }
}
