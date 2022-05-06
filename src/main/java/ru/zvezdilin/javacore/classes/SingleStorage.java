package ru.zvezdilin.javacore.classes;

import ru.zvezdilin.javacore.interfaces.IStorage;

import java.util.ArrayList;
import java.util.List;

public class SingleStorage implements IStorage {
    protected static SingleStorage singleStorage;
    private List<String> todosList;

    private SingleStorage() {
    }

    public static SingleStorage getStorage() {
        if (singleStorage == null)
            singleStorage = new SingleStorage();
        return singleStorage;
    }

    public List<String> getTodosList() {
        if (this.todosList == null)
            todosList = new ArrayList<>();
        return todosList;
    }
}


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