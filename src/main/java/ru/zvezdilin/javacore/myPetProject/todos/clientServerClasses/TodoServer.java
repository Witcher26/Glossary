package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.*;

import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

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

    public void start() {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            while (true) {  //TODO прописать условие выполнения бесконечного цикла

                String requestFromClientInJson = in.readLine();
                JsonElement rootNode = JsonParser.parseString(requestFromClientInJson);
                JsonObject details = rootNode.getAsJsonObject();

                String type = details.get("type").getAsString();
                String languageInJson = details.get("task").getAsString();
                Language language = jsonToLanguage(languageInJson);  //TODO преобразовываем строки json в объект language


                switch (type) {
                    case "ADD":
                        todos.addTask(language);  //TODO преобразование в объект, надо смотреть JSON
                        break;
                    case ("REMOVE"):
                        todos.removeTask(language); //TODO преобразование в объект, надо смотреть JSON
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

    public static Language jsonToLanguage(String json) {
        Language language = null;   //TODO в целом не нравится здесь наличие NULL
        JsonArray jsonElements = (JsonArray) JsonParser.parseString(json);
        Gson gson = new GsonBuilder().create();
        for (Object jsonObject : jsonElements) {
            language = gson.fromJson((JsonObject) jsonObject, Language.class);
        }
        return language;
    }
}






