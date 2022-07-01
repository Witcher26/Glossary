package com.zvezdilin.GlossaryTests.database;

//import com.zvezdilin.Glossary.controller.confing.ConnectionSettings;
//import com.zvezdilin.Glossary.controller.confing.DatabaseConfig;
//import com.zvezdilin.Glossary.database.postgresQL.ProfileDao;
//import com.zvezdilin.Glossary.database.postgresQL.ProfileDaoImpl;
//import com.zvezdilin.Glossary.database.postgresQL.ProfileMapper;
//import com.zvezdilin.Glossary.database.postgresQL.ProfileServiceImpl;

import com.zvezdilin.Glossary.database.postgresQL.StorageConnectorHelper;
import com.zvezdilin.Glossary.database.postgresQL.PostgreSqlDao;
import com.zvezdilin.Glossary.engine.StorageConnector;
import org.junit.jupiter.api.*;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PostgresqlTests {
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
    public void testCreateDatabase() {
        PostgreSqlDao dao = new PostgreSqlDao();
        StorageConnectorHelper storageTodosConnectorHelper = new StorageConnectorHelper();

        StorageConnector connector = StorageConnector.getConnector();

        boolean result = dao.createDatabase();

        Assertions.assertEquals(true, result);
    }

    @Test
    public void testUpdateDatabase() {
        PostgreSqlDao dao = new PostgreSqlDao();
        StorageConnectorHelper storageTodosConnectorHelper = new StorageConnectorHelper();

        StorageConnector connector = StorageConnector.getConnector();
        connector.addWord("unit", "единица измерения", "EN");
        connector.addWord("summary", "резюмировать", "EN");
        connector.addWord("rejected", "отклоненный", "EN");
        connector.addWord("related", "связанный", "EN");
        connector.addWord("counterpart", "копия", "EN");
        connector.addWord("enhancement", "доработка", "EN");

        boolean result = dao.updateDatabase();

        Assertions.assertEquals(false, result);
    }


    @Test
    public void testReadDatabase() {
        PostgreSqlDao dao = new PostgreSqlDao();
        StorageConnectorHelper storageTodosConnectorHelper = new StorageConnectorHelper();

        StorageConnector connector = StorageConnector.getConnector();

        boolean result = dao.readDatabase();

        Assertions.assertEquals(true, result);
    }

    @Test
    public void testDeleteDatabase() {
        PostgreSqlDao dao = new PostgreSqlDao();
        StorageConnectorHelper storageTodosConnectorHelper = new StorageConnectorHelper();

        StorageConnector connector = StorageConnector.getConnector();

        boolean result = dao.deleteDatabase();

        Assertions.assertEquals(true, result);
    }
}
