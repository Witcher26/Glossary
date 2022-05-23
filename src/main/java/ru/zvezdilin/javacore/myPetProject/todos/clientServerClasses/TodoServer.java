package ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;
//    private static Socket clientSocket; //сокет для общения
//    private static ServerSocket server; // серверсокет
//    private static BufferedReader in; // поток чтения из сокета
//    private static BufferedWriter out; // поток записи в сокет

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket server = new ServerSocket(port);
             Socket clientSocket = server.accept();

             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Сервер запущен!");

            Gson gson = new GsonBuilder().create();



            while (true) {
                String jsonString = in.readLine();
                System.out.println("Команда принята");

                var c = gson.toJson()

                switch (jsonString) {
                    case (add):
                        //TODO;
                        break;
                    case (remove):
                        //TODO;
                        break;
                    case (getString):
                        //TODO;
                        break;
                }



            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
