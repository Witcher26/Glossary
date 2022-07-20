package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * класс неклиентских запросов.
 * По умолчанию сохрание идет в базу данных MongoDb
 */

@Tag(name = "Admin controller", description = "управление базами данных")
@RestController
@RequestMapping(value = "api/adminController/v1/")
public class AdminController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static AdminController admin;
    private static IsDataBase isDataBase;
    private static DAO dao;

    private AdminController() {
    }

    public static synchronized AdminController getAdmin() {
        if (admin == null) {
            admin = new AdminController();
            isDataBase = IsDataBase.MONGODB;
        }
        return admin;
    }

    public IsDataBase getIsDataBase() {
        return isDataBase;
    }

    public DAO getDao() {
        return dao;
    }

    @Operation(
            summary = "переключение между базами данных",
            description = "по умолчанию активна база данных - MongoDB"
    )
    @PostMapping(value = "switchDataBase")
    public String switchDataBase(@RequestParam @Parameter(description = "MONGODB or POSTGRESQL") String isDataBase) {
        IsDataBase handler = IsDataBase.valueOf(isDataBase);

        if (handler == IsDataBase.MONGODB) {
            AdminController.isDataBase = IsDataBase.MONGODB;
        }

        if (handler == IsDataBase.POSTGRESQL) {
            AdminController.isDataBase = IsDataBase.POSTGRESQL;
        }

        myLogger.appendInfo("Switched Database to " + isDataBase);
        return "Switched Database to " + isDataBase;
    }

    @Operation(
            summary = "создание базы данных",
            description = "по умолчанию активна база данных MongoDB"
    )
    @PostMapping(value = "createDataBase")
    public String createDataBase() {

        boolean tmp;
        if (getIsDataBase()==IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        }

        if (getIsDataBase()==IsDataBase.POSTGRESQL) {
            dao = new PostgreSqlDao();
        }

        tmp = dao.createDatabase();
        myLogger.appendInfo("Attempt to create a database: " + getIsDatabaseInfo() + ". " + "Status: " + tmp);
        return "Created database a " + isDataBase;
    }

    @Operation(
            summary = "удаление базы данных",
            description = "по умолчанию активна база данных MongoDB"
    )
    @DeleteMapping(value = "deleteDataBase")
    public String deleteDataBase() {

        boolean tmp;
        if (getIsDataBase()==IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        }

        if (getIsDataBase()==IsDataBase.POSTGRESQL) {
            dao = new PostgreSqlDao();
        }

        tmp = dao.deleteDatabase();
        myLogger.appendInfo("Attempt to delete a database: " + getIsDatabaseInfo() + ". " + "Status: " + tmp);
        return "deleted database a " + isDataBase;
    }

    @Operation(
            summary = "получение информации о текущей базе данных",
            description = "по умолчанию активна база данных MongoDB"
    )
    @GetMapping("getIsDatabase")
    public String getIsDatabaseInfo() {
        return "Current database is a " + getIsDataBase().toString();
    }

    @Operation(
            summary = "логгер"
    )
    @GetMapping("getLoggerInfo")
    public String getLoggerInfo() {
        return MySingletonLogger.getLogger().getInfo();
    }
}
