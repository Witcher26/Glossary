package com.zvezdilin.GlossaryTests.database;

import com.zvezdilin.Glossary.api.AdminController;
import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.database.mongoDB.MongoDbDao;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
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

    @Test
    public void switchDataBaseTest() {
        AdminController controller =AdminController.getAdmin();

        System.out.println("Текущая база данных: " + controller.getIsDatabaseInfo());
        String tmp;
        String switchTo = "POSTGRESQL";

        tmp = controller.switchDataBase(switchTo);

        System.out.println(tmp);

        switchTo = "MONGODB";
        tmp = controller.switchDataBase(switchTo);

        System.out.println(tmp);
    }

    @Test
    public void testCreateDatabaseAdapter() {
        //arrange
        DAO adapterMongoDB = new MongoDbDao();
        DAO adapterPostgresql = new PostgreSqlDao();

        ///act
        boolean resultMongoDb = adapterMongoDB.createDatabase();
        boolean resultPostgresql = adapterPostgresql.createDatabase();

        //assert
        Assertions.assertEquals(true, resultMongoDb);
        Assertions.assertEquals(true, resultPostgresql);
    }

    @Test
    public void testReadDatabaseAdapter() {
        //arrange
        DAO adapterMongoDB = new MongoDbDao();
        DAO adapterPostgresql = new PostgreSqlDao();
        StorageConnector connector = new StorageConnector();

        ///act

        boolean resultMNG = adapterMongoDB.readDatabase();
        boolean resultPSTGR = adapterPostgresql.readDatabase();

        System.out.println(connector.getAllWords());

        //assert
        Assertions.assertEquals(true, resultMNG);
        Assertions.assertEquals(true, resultPSTGR);
    }

    @Test
    public void testUpdateDatabaseAdapter() {
        //arrange
        DAO adapterMongoDB = new MongoDbDao();
        DAO adapterPostgresql = new PostgreSqlDao();

        StorageConnector storage = new StorageConnector();
        storage.addWord("TestOne", "первый тест", "en");
        storage.addWord("testTwo", "второй тест", "En");

        ///act
        boolean resultMNG = adapterMongoDB.updateDatabase();
        boolean resultPSTGR = adapterPostgresql.updateDatabase();

        //assert
        Assertions.assertEquals(true, resultMNG);
        Assertions.assertEquals(true, resultPSTGR);

    }

    @Test
    public void testDeleteDataBaseAdapter() {
        //arrange
        DAO adapterMongoDB = new MongoDbDao();
        DAO adapterPostgresql = new PostgreSqlDao();

        //act
        boolean resultMNG = adapterMongoDB.deleteDatabase();
        boolean resultPSTGR = adapterPostgresql.deleteDatabase();

        //assert
        Assertions.assertEquals(true, resultMNG);
        Assertions.assertEquals(true, resultPSTGR);
    }

}
