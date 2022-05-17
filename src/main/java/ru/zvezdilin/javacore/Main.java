package ru.zvezdilin.javacore;

//import ru.zvezdilin.javacore.classes.TodoServer;
//import ru.zvezdilin.javacore.classes.Todos;

import ru.zvezdilin.javacore.myPetProject.todos.classes.SingletonStorage;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosStorageAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        SingletonStorage storage = SingletonStorage.getStorageInstance();
        Todos todos = new Todos(storage);
        TodosStorageAdapter adapter = new TodosStorageAdapter(storage);

        Todos todos = new Todos(adapter);
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();
        System.out.println("start");

        String s1 = "d";
        String s2=null;

        System.out.println(Objects.equals(s1, s2));
    }
}
