package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

import java.util.Map;


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
    public void removeTask(Language word) {
        //TODO добавить возможность удаления заданий по номеру.
        String strToLowCase = word.getWord().toLowerCase();
        if (todosList.containsKey(strToLowCase)) {
            System.out.println("Слово " + word.getWord() + " удалено");
            todosList.remove(word.getWord());
        } else {
            System.out.println("Нет совпадений");
        }
    }

    public String getAllTasks() {
        if (todosList.isEmpty()) {
            System.out.println("Список заданий пуст");
            return "Слова отсутствуют";
        }

        StringBuilder sb = new StringBuilder();  //TODO реализация через SB

        for (Map.Entry<String, Language> entry : todosList.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }
}