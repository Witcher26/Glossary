package com.zvezdilin.Glossary.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MySingletonLogger {
    protected int stepNumber = 1;

    private static MySingletonLogger logger;
    protected static StringBuilder loggerInfo;

    private MySingletonLogger() {
    }

    public static synchronized MySingletonLogger getLogger() {
        if (logger == null) {
            loggerInfo = new StringBuilder();
        }
        return logger;
    }

    public void getInfo(String str) {
        loggerInfo.append("[" + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME) +
                " шаг_№_" +
                stepNumber++ +
                "] " +
                str);
        System.out.println("[" + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME) +
                " шаг_№_" +
                stepNumber++ +
                "] " +
                str);
    }
}
