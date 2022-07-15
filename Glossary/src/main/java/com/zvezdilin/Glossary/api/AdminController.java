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

    static IsDataBase getIsDataBase() {
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
        } else {
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
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            dao = new PostgreSqlDao();
        }
        dao.createDatabase();
        myLogger.appendInfo("Attempt to create a database. Status: " + getIsDatabaseInfo());
        return "Created database a " + getIsDatabaseInfo();
    }

    @Operation(
            summary = "удаление базы данных",
            description = "по умолчанию активна база данных MongoDB"
    )
    @PostMapping(value = "deleteDataBase")
    public String deleteDataBase() {
        if (isDataBase == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        } else {
            dao = new PostgreSqlDao();
        }
        dao.deleteDatabase();
        myLogger.appendInfo("Attempt to delete a database " + getIsDatabaseInfo());
        return "deleted database a " + getIsDatabaseInfo();
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
            summary = "Логгер"
    )
    @GetMapping("getLoggerInfo")
    public String getLoggerInfo() {
        return MySingletonLogger.getLogger().getInfo();
    }
}
