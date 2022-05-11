package ru.zvezdilin.javacore.myPetProject.todos.logger;


import ru.zvezdilin.javacore.myPetProject.todos.interfaces.ILogger;

import java.time.LocalDateTime;

public class SingletonLogger implements ILogger {
    protected int stepNumber = 1;

    private static SingletonLogger logger;
    protected StringBuilder loggerInfo;

    private SingletonLogger() {
    }

    public static synchronized SingletonLogger getLogger() {
        if (logger == null)
            logger = new SingletonLogger();
        return logger;
    }

    @Override
    public void append(String str) {
        loggerInfo.append("[ " + LocalDateTime.now() + " шаг №_" + stepNumber++ + " ] " + str);
    }
}
