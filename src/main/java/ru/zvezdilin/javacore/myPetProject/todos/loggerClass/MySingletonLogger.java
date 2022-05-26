package ru.zvezdilin.javacore.myPetProject.todos.loggerClass;

import ru.zvezdilin.javacore.myPetProject.todos.interfaces.ILogger;

import java.time.LocalDateTime;

public class MySingletonLogger implements ILogger {
    protected int stepNumber = 1;

    private static MySingletonLogger logger;
    protected static StringBuilder loggerInfo;

    private MySingletonLogger() {
    }

    public static synchronized MySingletonLogger getLogger() {
        if (logger == null){
            loggerInfo = new StringBuilder();
        }
            logger = new MySingletonLogger();
        return logger;
    }

    @Override
    public void append(String str) {
        loggerInfo.append("[ " + LocalDateTime.now() + " шаг №_" + stepNumber++ + " ] " + str);
        System.out.println("[ " + LocalDateTime.now() + " шаг №_" + stepNumber + " ] " + str);
    }
}
