package com.zvezdilin.Glossary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zvezdilin.Glossary")
public class GlossaryApplication {

    public static void main(String[] args) {
        MySingletonLogger logger = MySingletonLogger.getLogger();
        logger.getInfo("start SpringApplication.run");
        SpringApplication.run(GlossaryApplication.class, args);


//        logger.getInfo("инициализация класса TodosLanguageStorageConnector");
//        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();
//
//        logger.getInfo("инициализация класса Engine");
//        Engine engine = new Engine();
//
//        logger.getInfo("инициализация класса Database");
//        Database database = DatabaseAdapter.getInstance();
    }
}
