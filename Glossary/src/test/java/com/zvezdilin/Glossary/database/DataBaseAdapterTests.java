package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.database.mongoDB.DatabaseAdapter;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.English;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

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
    public void testCreateInDatabaseAdapter(){
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        English unit = new English("summary", "резюмировать");

        ///act
        boolean result = adapter.createEntity(unit);

        //assert
        Assertions.assertEquals(true,result);
    }

    @Test
    public void testReadEntityInDatabaseAdapter(){
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        English unit = new English("summary", "резюмировать");
        adapter.createEntity(unit);
        List<BaseEntity> expect = new ArrayList<>();
        expect.add((new English("summary", "резюмировать")));


        ///act
        List<BaseEntity> result = adapter.readEntity();

        //assert
        Assertions.assertEquals(expect,result);
    }

    @Test
    public void testUpdateEntityInDatabaseAdapter(){
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        English unit = new English("summary", "резюмировать");
        adapter.createEntity(unit);
        List<BaseEntity> expect = new ArrayList<>();
        expect.add((new English("summary", "резюмировать")));


        ///act
        List<BaseEntity> result = adapter.readEntity();

        //assert
        Assertions.assertEquals(expect,result);
    }

}
