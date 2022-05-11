package ru.zvezdilin.javacore.myPetProject.todos.classes;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.IStorage;

import java.util.List;

public class ListStorageAdapter implements IStorage {
        protected List<String> todosList;

    public ListStorageAdapter(List<String> todosList) {
        this.todosList = todosList;
    }
    @Override
    public void addTask(String task){
        todosList.add(task);
    }

    @Override
    public void removeTask(String task) {
        todosList.remove(task);
    }

    public String getAllTasks() {
        StringBuilder tasks = new StringBuilder();

        for (String task : todosList) {
            tasks.append(tasks + "\n");
        }
        return tasks.toString();
    }
}


//    public List<String> getTodosList() {
//        if (this.todosList == null)
//            todosList = new ArrayList<>();
//        return todosList;
//    }


//public class Adapter {
//
//    public interface IStorage {
//        void append(String str);
//    }
//
//    public static class Log {
//        protected final Adapter.IStorage storage;
//
//        public Log(IStorage iStorage) {
//            this.storage = iStorage;
//        }
//
//        public void log(String log) {
//            storage.append(log);
//        }
//    }
//
//    // TODO 1 вариант - посредник
//    public static class ListStorageAdapter implements IStorage {
//        protected List<String> list;
//
//        public ListStorageAdapter(List<String> list) {
//            this.list = list;
//        }
//
//        @Override
//        public void append(String str) {
//            list.add(str);
//        }
//    }
//
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Log log = new Log(new ListStorageAdapter(list));
//        log.log("World");
//    }
//}