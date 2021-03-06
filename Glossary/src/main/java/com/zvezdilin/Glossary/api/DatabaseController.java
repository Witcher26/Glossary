package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Database controller", description = "чтение и обновление баз данных")
@RestController
@RequestMapping(value = "api/databaseController/v1/")
public class DatabaseController {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static IsDataBase isDataBase;
    private static AdminController admin;
    private DAO dao;

    public DatabaseController() {
    }

    @Operation(
            summary = "чтение из базы данных",
            description = "по умалчанию MongoDB"
    )
    @GetMapping("database/read")
    public boolean readDbBase() {
        boolean tmp;
        admin= AdminController.getAdmin();
        if (admin.getIsDataBase() == IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        }

        if (admin.getIsDataBase() == IsDataBase.POSTGRESQL) {
            dao = new PostgreSqlDao();
        }

        tmp = dao.readDatabase();
        myLogger.appendInfo("Attempt to read a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }

    @Operation(
            summary = "обновление базы данных",
            description = "по умалчанию MongoDB"
    )
    @PutMapping("database/update")
    public boolean updateDataBase() {
        boolean tmp;
        admin = AdminController.getAdmin();

        if (admin.getIsDataBase()== IsDataBase.MONGODB) {
            dao = new MongoDbDao();
        }
        if (admin.getIsDataBase()== IsDataBase.POSTGRESQL) {
            dao = new PostgreSqlDao();
        }
        tmp = dao.updateDatabase();
        myLogger.appendInfo("Attempt to update a database. Status: " + String.valueOf(tmp).toUpperCase());
        return tmp;
    }
}
