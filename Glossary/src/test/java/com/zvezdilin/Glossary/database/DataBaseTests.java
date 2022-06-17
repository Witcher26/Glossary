package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import org.junit.jupiter.api.*;

public class DataBaseTests {
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
    public void testCreateInDatabase(){
        //arrange
        DatabaseAdapter adapter = DatabaseAdapter.getInstance();
        English unit = new English("summary", "резюмировать");

        ///act
        boolean result = adapter.createEntity(unit);

        //assert
        Assertions.assertEquals(true,result);
    }
}
