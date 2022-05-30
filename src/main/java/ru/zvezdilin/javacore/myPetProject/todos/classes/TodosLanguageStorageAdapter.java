package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class TodosLanguageStorageAdapter implements IStorage {
    private Map<String, Language> todosList;

    public TodosLanguageStorageAdapter(Map<String, Language> todosList) {
        this.todosList = todosList;
    }

    @Override
    public void addTask(Language word) {
        //TODO добавить pattern - проверки не по всей строке, а разбивать на слова, проверять 3-е слово, без окончания
        String strToLowCase = word.getWord().toLowerCase();
        if (todosList.containsKey(strToLowCase)) {
            System.out.println("Данное слово уже присутствует в словаре");
        } else {
            todosList.put(strToLowCase, word);
        }
    }

    @Override
    public void removeTask(String language) {
        //TODO добавить возможность удаления заданий по номеру.
        String strToLowCase = language.toLowerCase();
        if (todosList.containsKey(strToLowCase)) {
            System.out.println("Слово " + language + " удалено");
            todosList.remove(strToLowCase);
        } else {
            System.out.println("Нет совпадений");
        }
    }


//    @Override
//    public int compare(StringBuilder st1, StringBuilder st2){
//        return st1.toString().compareTo(st2.toString());
//    }

    public String getAllTasks() {
        if (todosList.isEmpty()) {
            System.out.println("Слова отсутствуют в списке");
            return "Слова отсутствуют в списке";
        }

        StringBuilder sb = new StringBuilder();  //TODO реализация через SB

        //TODO реализоваться comparator
        for (Map.Entry<String, Language> entry : todosList.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }
}