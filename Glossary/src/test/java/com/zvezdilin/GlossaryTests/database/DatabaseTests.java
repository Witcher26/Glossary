package com.zvezdilin.GlossaryTests.database;

//import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;

import com.zvezdilin.Glossary.api.AdminController;
import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.engine.Engine;
import com.zvezdilin.Glossary.engine.StorageConnector;
import org.junit.jupiter.api.*;

public class DatabaseTests {
    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }

//    @Test
//    public void switchDataBaseTest(String POSTGRESQL) {
//        boolean tmp;
//        AdminController controller = new AdminController();
//        tmp = controller.switchDataBase(POSTGRESQL);
//
//        System.out.println(tmp);
//    }


//    @Test
//    public void testCreateDatabaseAdapter() {
//        //arrange
////        MongoDbDao adapter = MongoDbDao.getInstance();
////        StorageConnector connector = StorageConnector.getConnector();
//
//        connector.addWord("unit", "единица измерения", "EN");
//        connector.addWord("summary", "резюмировать", "EN");
//        connector.addWord("rejected", "отклоненный", "EN");
//        connector.addWord("related", "связанный", "EN");
//        connector.addWord("counterpart", "копия", "EN");
//        connector.addWord("enhancement", "доработка", "EN");
//
//        ///act
////        boolean result = adapter.createDatabase();
//
//        //assert
//        Assertions.assertEquals(true, result);
//    }

    @Test
    public void testReadDatabaseAdapter() {
        //arrange
        MongoDbDao adapter = new MongoDbDao();
        StorageConnector connector = new StorageConnector();

        connector.addWord("unit", "единица измерения", "EN");
        connector.addWord("summary", "резюмировать", "EN");
        connector.addWord("rejected", "отклоненный", "EN");
        connector.addWord("related", "связанный", "EN");
        connector.addWord("counterpart", "копия", "EN");
        connector.addWord("enhancement", "доработка", "EN");

        adapter.createDatabase();
//        List<BaseEntity> expect = new ArrayList<>();
//        expect.add((new English("summary", "резюмировать")));

        ///act
        boolean result = adapter.readDatabase();

        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testUpdateDatabaseAdapter() {
        //arrange
        DAO adapter = new MongoDbDao();
        StorageConnector storage = new StorageConnector();
        storage.addWord("debug", "отлаживать", "En");
        storage.addWord("ss", "опаап", "En");

        ///act
        boolean result = adapter.updateDatabase();

        //assert
        Assertions.assertEquals(true, result);
    }
//
//    @Test
//    public void testDeleteDataBaseAdapter() {
//        //arrange
//        MongoDbDao adapter = MongoDbDao.getInstance();
//        StorageConnector connector = StorageConnector.getConnector();
//
//        //act
//        boolean result = adapter.deleteDatabase();
//
//        //assert
//        Assertions.assertEquals(true, result);
//    }

}
