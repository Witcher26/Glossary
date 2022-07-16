package com.zvezdilin.GlossaryTests.database;

import com.zvezdilin.Glossary.api.AdminController;
import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import com.zvezdilin.Glossary.engine.StorageConnector;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.English;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void switchDataBaseTest() {
        String tmp;
        String switchTo = "POSTGRESQL";
        AdminController controller =AdminController.getAdmin();
        tmp = controller.switchDataBase(switchTo);

        System.out.println(tmp);

        switchTo = "MONGODB";
        tmp = controller.switchDataBase(switchTo);

        System.out.println(tmp);
    }


    @Test
    public void testCreateDatabaseAdapter() {
        //arrange
        DAO adapter = new PostgreSqlDao();

        ///act
        boolean result = adapter.createDatabase();

        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testReadDatabaseAdapter() {
        //arrange
        DAO adapter = new MongoDbDao();
        StorageConnector connector = new StorageConnector();

//        connector.addWord("unit", "единица измерения", "EN");
//        connector.addWord("summary", "резюмировать", "EN");
//        connector.addWord("rejected", "отклоненный", "EN");
//        connector.addWord("related", "связанный", "EN");
//        connector.addWord("counterpart", "копия", "EN");
//        connector.addWord("enhancement", "доработка", "EN");

//        adapter.createDatabase();
//        List<BaseEntity> expect = new ArrayList<>();
//        expect.add((new English("summary", "резюмировать")));

        ///act
        boolean resultMongo = adapter.readDatabase();
        System.out.println(connector.getAllWords());

        adapter = null;

        DAO adapter2 = new PostgreSqlDao();
        boolean resultPostgresQL = adapter2.readDatabase();
        System.out.println(connector.getAllWords());


        //assert
        Assertions.assertEquals(true, resultMongo);
        Assertions.assertEquals(true, resultPostgresQL);
    }

    @Test
    public void testUpdateDatabaseAdapter() {
        //arrange
        DAO adapter = new PostgreSqlDao();
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
