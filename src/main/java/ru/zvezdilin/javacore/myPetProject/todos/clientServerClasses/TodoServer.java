package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.*;

import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


            while (true) {  //TODO условие выполнения бесконечного цикла

                String wordInJson = in.readLine();
                JsonElement rootNode = JsonParser.parseString(wordInJson);
                JsonObject details = rootNode.getAsJsonObject();

                String type = details.get("type").getAsString();
                var task = details.get("task").getAsString();

                switch (type) {
                    case "ADD":
//                        todos.addTask(task);  //TODO преобразование в объект, надо смотреть JSON
                        break;
                    case ("REMOVE"):
//                        todos.removeTask(task); //TODO преобразование в объект, надо смотреть JSON
                        break;
                    case ("getAllTasks"):
                        todos.getAllTasks();
                        break;
                }
                out.println(todos.getAllTasks());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






