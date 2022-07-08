package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/databaseController/v1/")
public class DatabaseController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static IsDataBase isDataBase = AdminController.getIsDataBase();
    private DAO dao;

    public DatabaseController() {
    }

    @GetMapping("database/read")
    public boolean readDbBase() {
        boolean tmp;
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            isDataBase = IsDataBase.POSTGRESQL;
            dao = new PostgreSqlDao();
        }
        tmp = dao.readDatabase();
        myLogger.appendInfo("Attempt to read a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }

    @GetMapping("database/update")
    public boolean updateDataBase() {
        boolean tmp;
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            isDataBase = IsDataBase.POSTGRESQL;
            dao = new PostgreSqlDao();
        }
        tmp = dao.updateDatabase();
        myLogger.appendInfo("Attempt to update a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }
}
