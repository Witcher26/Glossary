package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import org.springframework.web.bind.annotation.*;

/**
 * класс неклиентских запросов.
 * По умалчанию сохрание идет в MongoDb
 */

@RestController
@RequestMapping(value = "api/adminController/v1/")
public class AdminController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static IsDataBase isDataBase;
    private static DAO dao;
    private static AdminController admin;

    private AdminController() {
    }

    public static synchronized AdminController getAdmin() {
        if (admin == null) {
            admin = new AdminController();
            isDataBase = IsDataBase.MONGODB;
        }
        return admin;
    }

    public static IsDataBase getIsDataBase() {
        return isDataBase;
    }

    public DAO getDao() {
        return dao;
    }

    @PostMapping(value = "switchDataBase")
    public String switchDataBase(@RequestParam String isDataBase) {
        IsDataBase handler= IsDataBase.valueOf(isDataBase);
        if (handler == IsDataBase.MONGODB) {
            AdminController.isDataBase = IsDataBase.MONGODB;
        } else {
            AdminController.isDataBase = IsDataBase.POSTGRESQL;
        }
        myLogger.appendInfo("Switched Database to " + isDataBase);
        return "Switched Database to "+ isDataBase;
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
