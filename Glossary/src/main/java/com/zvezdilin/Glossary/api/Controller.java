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

@RestController //обработчик входящих rest-запросов
@RequestMapping(value = "api/controller/v1/")
//@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
/*
/через параметр produces мы указываем, что контроллер возвращает ответ в формате json.
 */
public class Controller {
    private static MySingletonLogger myLogger = MySingletonLogger.getLogger();
    private static Controller controller;
    private static Engine engine;
    private static StorageConnector connector;
    private static DAO databaseMongoDB;
    private static DAO databasePostgresQL;

    public Controller() {
        myLogger.getInfo("Start controller api");

        myLogger.getInfo("Инициализация " + Controller.class.getName());
//        Controller controller = new Controller();


        myLogger.getInfo("Инициализация " + Engine.class.getName());
        Engine engine = new Engine();

        myLogger.getInfo("Инициализация " + StorageConnector.class.getName());
        StorageConnector connector = new StorageConnector();

        myLogger.getInfo("Инициализация " + MongoDbDao.class.getName());
        MongoDbDao mongo = new MongoDbDao();

        myLogger.getInfo("Инициализация " + MongoDbHelper.class.getName());
        MongoDbHelper helper = new MongoDbHelper();
    }

    @PostMapping("startEngine/")
    public String startEngine(@RequestBody String requestFromClientInJson) {
        Engine engine = new Engine();
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








//    @PostMapping("startController")
//    public St startController() {
//        if (controller == null) {
//            controller = new Controller();
//        }
//        myLogger.getInfo("Start controller api");
//        myLogger.getInfo("инициализация TodosLanguageStorageConnector");
//        connector = StorageConnector.getConnector();
//
//        myLogger.getInfo("инициализация Engine");
//        engine = new Engine();
//
//        myLogger.getInfo("инициализация Database");
//        databaseMongoDB = MongoDbDao.getInstance();
//        databasePostgresQL = new PostgreSqlDao();
//
//        return controller;
//    }




//    @GetMapping(value = "/{personId:\\d+}")  //{personId:\d+} переменная + регулярка
//    public Profile getProfile(@PathVariable int personId) {
//        return profileService.getProfile(personId);
//    }
}
