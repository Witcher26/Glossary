package com.zvezdilin.Glossary.database.mongoDB;

import com.mongodb.client.*;
import com.zvezdilin.Glossary.database.Database;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Client;
import com.zvezdilin.Glossary.model.entity.English;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseAdapter implements Database {
    private static final Logger logger = Logger.getLogger("DataStorageAdapter class");
    private static DatabaseAdapter instance;

    private DatabaseAdapter() {
    }

    public static DatabaseAdapter getInstance() {
        if (instance == null) {
            instance = new DatabaseAdapter();
        }
        return instance;
    }

//    @Autowired
    @Override
    public boolean createEntity(BaseEntity baseEntity) {  //TODO client не нужон?
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Glossary");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("English");
            mongoCollection.insertOne(DatabaseHelper.toDoc(baseEntity));
            return true;
        } catch (Exception e) {
            logger.warning("Неудачная попытка добавления объекта в базу данных: " + e.getMessage());
            return false;
        }
    }


    @Override
    public List<BaseEntity> readEntity() {  //TODO client не нужон
        List<BaseEntity> result = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase database = mongoClient.getDatabase("Glossary");
            MongoCollection<Document> collection = database.getCollection("English");
            MongoCursor<Document> cursor = collection.find().cursor();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                result.add(DatabaseHelper.fromDoc(document));
            }
            return result;
        } catch (Exception e) {
            logger.warning("Ошибка чтения: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateEntity(BaseEntity baseEntity) {
//        List<BaseEntity> result = new ArrayList<>();
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase database = mongoClient.getDatabase("Glossary");
//            MongoCollection<Document> collection = database.getCollection("English");
//            collection.updateOne
//            MongoCursor<Document> cursor = collection.find().cursor();
//            while (cursor.hasNext()) {
//                Document document = cursor.next();
//                result.add(DatabaseHelper.fromDoc(document));
//            }
//            return result;
//        } catch (Exception e) {
//            logger.warning("Ошибка чтения: " + e.getMessage());
//            return null;
//        }
        return false;
    }

    @Override
    public boolean deleteEntity(String word) {
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase database = mongoClient.getDatabase("Glossary");
//            MongoCollection<Document> collection = database.getCollection("English");
//            collection.find(word);
//            collection.deleteOne(new Document().get(baseEntity))
//            return true;
//        } catch (Exception e) {
//            logger.warning("Не удалось удалить коллекцию" + e.getMessage());
//            return false;
//        }
        return false;
    }

}
