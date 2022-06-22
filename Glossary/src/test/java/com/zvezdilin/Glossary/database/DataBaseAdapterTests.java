package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.database.mongoDB.DatabaseAdapter;
import com.zvezdilin.Glossary.engine.TodosLanguageStorageConnector;
import org.junit.jupiter.api.*;

public class DataBaseAdapterTests {
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
    public void testCreateDatabaseAdapter() {
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        connector.addWord("unit", "единица измерения", "EN");
        connector.addWord("summary", "резюмировать", "EN");
        connector.addWord("rejected", "отклоненный", "EN");
        connector.addWord("related", "связанный", "EN");
        connector.addWord("counterpart", "копия", "EN");
        connector.addWord("enhancement", "доработка", "EN");

        ///act
        boolean result = adapter.createDatabase();

        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testReadDatabaseAdapter() {
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

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
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        ///act
        boolean result= adapter.updateDatabase();

        //assert
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testDeleteDataBaseAdapter() {
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        //act
        boolean result = adapter.deleteDatabase();

        //assert
        Assertions.assertEquals(true, result);
    }

}
