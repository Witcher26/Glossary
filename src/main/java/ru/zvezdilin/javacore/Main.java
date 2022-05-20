package ru.zvezdilin.javacore;

import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosLanguageStorageAdapter;
import ru.zvezdilin.javacore.myPetProject.todos.clientServerClasses.TodoServer;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
//        Map<String, Language> storage = new HashMap<>();
////        List<String, Language> storage = new ArrayList<>();
//        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
//        Todos todos = new Todos(adapter);
//
//        todos.getAllTasks();
//        Language unit = new English("Unit", "единица измерения");
//        todos.addTask(new English("related", "связанный"));
//
//        System.out.println("Список слов: \n" + todos.getAllTasks());
//
//        todos.addTask(unit);
//        System.out.println("Список слов: \n" + todos.getAllTasks());
//
//        System.out.println("Удаление Unit");
//
//        todos.removeTask(unit);
//        System.out.println("Вывод списка");
//        System.out.println("Список слов: \n" + todos.getAllTasks());
//
//
//        TodoServer server = new TodoServer(8989, todos);
////        server.start();
////TODO в тест добавить мокирование

        String result =  choose(true, "first", "second");



    }

    public static <T> T choose(boolean flag, T s1, T s2) {
        if(true){
            return s1;
        }
        else
            return s2;
    }



}
