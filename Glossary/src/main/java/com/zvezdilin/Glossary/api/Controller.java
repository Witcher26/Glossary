package com.zvezdilin.Glossary.api;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import com.zvezdilin.Glossary.engine.Engine;
import com.zvezdilin.Glossary.engine.StorageConnector;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("api/engine/v1/")
@RestController  //обработчик входящих rest-запросов.
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
/*
через параметр produces мы указываем, что контроллер возвращает ответ в формате json.
 */
public class Controller {
    private static MySingletonLogger logger = MySingletonLogger.getLogger();
    private static Controller controller;
    private static Engine engine;
    private static StorageConnector connector;
    private static DAO databaseMongoDB;
    private static DAO databasePostgresQL;

    private Controller() {
    }

    public static synchronized Controller start() {
        if (controller == null) {
            controller = new Controller();
        }
        logger.getInfo("Start controller api");
        logger.getInfo("инициализация TodosLanguageStorageConnector");
        connector = StorageConnector.getConnector();

        logger.getInfo("инициализация Engine");
        engine = new Engine();

        logger.getInfo("инициализация Database");
        databaseMongoDB = MongoDbDao.getInstance();
        databasePostgresQL = new PostgreSqlDao();

        return controller;
    }

    @PostMapping("engine/v2/start")
    public String engineStart(@RequestBody String requestFromClientInJson) {
        return engine.start(requestFromClientInJson);
    }


//    @GetMapping(value = "/{personId:\\d+}")  //{personId:\d+} переменная + регулярка
//    public Profile getProfile(@PathVariable int personId) {
//        return profileService.getProfile(personId);
//    }
}
