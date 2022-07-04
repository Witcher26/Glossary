package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
//import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
//import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbHelper;
import com.zvezdilin.Glossary.engine.Engine;
import com.zvezdilin.Glossary.engine.StorageConnector;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/controller/v1/")
public class Controller {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static Controller controller;
    private static Engine engine;
    private static StorageConnector connector;
    private static DAO databaseMongoDB;
    private static DAO databasePostgresQL;

    private Controller() {
    }

    public static synchronized Controller getController() {
        if (controller == null) {
            controller = new Controller();
            engine = new Engine();
            connector = new StorageConnector();
            myLogger.getInfo("Start controller api");
            myLogger.getInfo("Инициализация " + Controller.class.getName() + ", "
                    + StorageConnector.class.getName() + ", "
                    + Engine.class.getName() + ", "
                    + MongoDbDao.class.getName() + ", "
                    + MongoDbHelper.class.getName()
            );
        }
        return controller;
    }


    @PostMapping("startEngine/")
    public String startEngine(@RequestBody String requestFromClientInJson) {
        Controller.getController();
        return engine.start(requestFromClientInJson);
    }

    @GetMapping("mongoDb/create")
    public boolean createMongoDbBase() {
        DAO mongo = new MongoDbDao();
        MongoDbHelper helper = new MongoDbHelper();
        return mongo.createDatabase();
    }

    @GetMapping("mongoDb/read")
    public boolean readMongoDbBase() {
        DAO mongo = new MongoDbDao();
        MongoDbHelper helper = new MongoDbHelper();
        return mongo.readDatabase();
    }

    @GetMapping("mongoDb/update")
    public boolean updateMongoDbBase() {
        DAO mongo = new MongoDbDao();
        MongoDbHelper helper = new MongoDbHelper();
        return mongo.updateDatabase();
    }

    @GetMapping("mongoDb/delete")
    public boolean deleteMongoDbBase() {
        DAO mongo = new MongoDbDao();
        MongoDbHelper helper = new MongoDbHelper();
        return mongo.deleteDatabase();
    }


//    @GetMapping(value = "/{personId:\\d+}")  //{personId:\d+} переменная + регулярка
//    public Profile getProfile(@PathVariable int personId) {
//        return profileService.getProfile(personId);
//    }
}
