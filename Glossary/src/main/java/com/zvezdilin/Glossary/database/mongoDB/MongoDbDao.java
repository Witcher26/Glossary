package com.zvezdilin.Glossary.database.mongoDB;

import com.mongodb.client.*;
import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.engine.GlobalRepository;
import com.zvezdilin.Glossary.engine.StorageConnector;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import org.bson.Document;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDbDao implements DAO {
    private static final Logger LOGGER = Logger.getLogger(MongoDbDao.class.getName());
    //    private static MongoDbDao instance;
    protected static final String DATABASE = "Glossary";
    protected static final String COLLECTION = "Words";
    GlobalRepository repository = GlobalRepository.getRepository();


//    StorageConnector connector = new StorageConnector();

    public MongoDbDao() {
    }

//    public static MongoDbDao getInstance() {
//        if (instance == null) {
//            instance = new MongoDbDao();
//        }
//        return instance;
//    }

    //    @Autowired
    @Override
    public boolean createDatabase() {
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Неудачная попытка создания базы данных: " + e.getMessage());
            return false;
        }
    }


//    @Override
//    public boolean createDatabase() {
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE);
//            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION);
//
//            List<BaseEntity> list = connector.listBaseEntity();
//
//            for(BaseEntity baseEntity: list){
//                mongoCollection.insertOne(MongoDbHelper.toDoc(baseEntity));
//            }
//            return true;
//        } catch (Exception e) {
//            LOGGER.warning("Неудачная попытка добавления объекта в базу данных: " + e.getMessage());
//            return false;
//        }
//    }


    @Override
    public boolean readDatabase() {
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            MongoCursor<Document> cursor = collection.find().cursor();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                repository.addBaseEntity(Objects.requireNonNull(MongoDbHelper.fromDoc(document)));
            }
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка чтения из базы данных: " + e.getMessage());
            return false;
        }
    }

//    @Override
//    public boolean updateDatabase() {
//        if(deleteDatabase()){
//            createDatabase();
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean updateDatabase() {
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION);

            List<BaseEntity> list = repository.getListBaseEntity();

            for (BaseEntity baseEntity : list) {
                mongoCollection.insertOne(MongoDbHelper.toDoc(baseEntity));
            }
            return true;
        } catch (Exception e) {
            LOGGER.warning("Неудачная попытка добавления объекта в базу данных: " + e.getMessage());
            return false;
        }
    }


    @Override
    public boolean deleteDatabase() {
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> collection = database.getCollection(COLLECTION);
            collection.drop();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Не удалось удалить коллекцию" + e.getMessage());
            return false;
        }
    }
}
