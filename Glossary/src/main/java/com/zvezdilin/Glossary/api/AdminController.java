package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import org.springframework.web.bind.annotation.*;

/**
 * класс неклиентских запросов
 */

@RestController
@RequestMapping(value = "api/adminController/v1/")
public class AdminController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static IsDataBase isDataBase = IsDataBase.MONGODB;
    private DAO dao;

    public AdminController() {
    }

    public static IsDataBase getIsDataBase() {
        return isDataBase;
    }

    public DAO getDao() {
        return dao;
    }

    @PostMapping(value = "switchDataBase")
    public String switchDataBase(@RequestParam String isDataBase) {
        IsDataBase isdb = IsDataBase.valueOf(isDataBase);
        if (isdb == IsDataBase.MONGODB) {
            AdminController.isDataBase = IsDataBase.MONGODB;
        } else {
            AdminController.isDataBase = IsDataBase.POSTGRESQL;
        }
        myLogger.appendInfo("Switched Database to " + isDataBase.toString());
        return "Switched Database to "+ isDataBase.toString();
    }

    @PostMapping(value = "createDataBase")
    public boolean createDataBase() {
        boolean tmp;
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            dao = new PostgreSqlDao();
        }
        tmp = dao.createDatabase();
        myLogger.appendInfo("Attempt to create a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }

    @PostMapping(value = "deleteDataBase")
    public boolean deleteDataBase() {
        boolean tmp;
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            dao = new PostgreSqlDao();
        }
        tmp = dao.deleteDatabase();
        myLogger.appendInfo("Attempt to delete a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }

    @GetMapping("getIsDatabase")
    public String getIsDatabase() {
        return getIsDataBase().toString();
    }

    @GetMapping("getLoggerInfo")
    public String getLoggerInfo() {
        return MySingletonLogger.getLogger().getInfo();
    }
}
