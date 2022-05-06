package ru.zvezdilin.javacore;

import ru.zvezdilin.javacore.classes.TodoServer;
import ru.zvezdilin.javacore.classes.Todos;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Todos todos = new Todos();
        TodoServer server = new TodoServer(8989, todos);
        server.start();
    }
}
