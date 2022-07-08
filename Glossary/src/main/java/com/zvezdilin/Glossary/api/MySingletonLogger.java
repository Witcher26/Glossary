package com.zvezdilin.Glossary.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MySingletonLogger {
    protected int stepNumber = 1;

    private static MySingletonLogger myLogger;
    protected static StringBuilder loggerInfo;

    private MySingletonLogger() {
    }

    public static synchronized MySingletonLogger getLogger() {
        if (myLogger == null) {
            myLogger = new MySingletonLogger();
            loggerInfo = new StringBuilder();
        }
        return myLogger;
    }

    public void appendInfo(String str) {
        loggerInfo.append("[" + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME) +
                " шаг_№_" +
                stepNumber++ +
                "] " +
                str +
                "\n");
    }

    public String getInfo() {
        return loggerInfo.toString();
    }
}
