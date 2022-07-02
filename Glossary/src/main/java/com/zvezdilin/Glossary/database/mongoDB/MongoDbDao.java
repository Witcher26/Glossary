//package com.zvezdilin.Glossary.database.mongoDB;
//
//import com.mongodb.client.*;
//import com.zvezdilin.Glossary.database.DAO;
//import com.zvezdilin.Glossary.engine.StorageConnector;
//import com.zvezdilin.Glossary.model.entity.BaseEntity;
//import org.bson.Document;
//
//import java.util.*;
//import java.util.logging.Logger;
//
//public class MongoDbDao implements DAO {
//    private static final Logger logger = Logger.getLogger("DataStorageAdapter class");
//    private static MongoDbDao instance;
//
//    StorageConnector connector = StorageConnector.getConnector();
//
//    private MongoDbDao() {
//    }
//
//    public static MongoDbDao getInstance() {
//        if (instance == null) {
//            instance = new MongoDbDao();
//        }
//        return instance;
//    }
//
////    @Autowired
//    @Override
//    public boolean createDatabase() {
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("Glossary");
//            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("Words");
//
//            List<BaseEntity> list = connector.listBaseEntity();
//
//            for(BaseEntity baseEntity: list){
//                mongoCollection.insertOne(MongoDbHelper.toDoc(baseEntity));
//            }
//            return true;
//        } catch (Exception e) {
//            logger.warning("Неудачная попытка добавления объекта в базу данных: " + e.getMessage());
//            return false;
//        }
//    }
//
//
//    @Override
//    public boolean readDatabase() {
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase database = mongoClient.getDatabase("Glossary");
//            MongoCollection<Document> collection = database.getCollection("Words");
//            MongoCursor<Document> cursor = collection.find().cursor();
//            while (cursor.hasNext()) {
//                Document document = cursor.next();
//                connector.addBaseEntity(Objects.requireNonNull(MongoDbHelper.fromDoc(document)));
//            }
//            return true;
//        } catch (Exception e) {
//            logger.warning("Ошибка чтения: " + e.getMessage());
//            return false;
//        }
//    }
//
//    @Override
//    public boolean updateDatabase() {
//        if(deleteDatabase()){
//            createDatabase();
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteDatabase() {
//        try (MongoClient mongoClient = MongoClients.create()) {
//            MongoDatabase database = mongoClient.getDatabase("Glossary");
//            MongoCollection<Document> collection = database.getCollection("Words");
//            collection.drop();
//            return true;
//        } catch (Exception e) {
//            logger.warning("Не удалось удалить коллекцию" + e.getMessage());
//            return false;
//        }
//    }
//}
