package ru.zvezdilin.javacore;

//import ru.zvezdilin.javacore.classes.TodoServer;
//import ru.zvezdilin.javacore.classes.Todos;

import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
//        Todos todos = new Todos();
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();
        System.out.println("start");

        String s1 = "d";
        String s2=null;

        System.out.println(Objects.equals(s1, s2));
    }
}
