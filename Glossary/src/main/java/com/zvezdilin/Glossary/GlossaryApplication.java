package com.zvezdilin.Glossary;

import com.zvezdilin.Glossary.database.Database;
import com.zvezdilin.Glossary.database.mongoDB.DatabaseAdapter;
import com.zvezdilin.Glossary.engine.Engine;
import com.zvezdilin.Glossary.engine.TodosLanguageStorageConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zvezdilin.Glossary")
public class GlossaryApplication {

    public static void main(String[] args) {
        MySingletonLogger logger = MySingletonLogger.getLogger();
        logger.getInfo("start SpringApplication.run");
        SpringApplication.run(GlossaryApplication.class, args);

        logger.getInfo("инициализация класса TodosLanguageStorageConnector");
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        logger.getInfo("инициализация класса Engine");
        Engine engine = new Engine();

        logger.getInfo("инициализация класса Database");
        Database database = DatabaseAdapter.getInstance();
    }
}
