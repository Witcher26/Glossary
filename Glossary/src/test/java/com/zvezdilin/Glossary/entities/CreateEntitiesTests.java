package com.zvezdilin.Glossary.entities;

import com.zvezdilin.Glossary.engineApi.TodosLanguageStorageConnector;
import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import com.zvezdilin.Glossary.model.exeptionClass.BadDataException;
import org.junit.jupiter.api.*;

public class CreateEntitiesTests {
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
    public void testCreateWord() {

        //arrange
        String expectedWord = "unit";
        String expectedTranslation = "единица измерения";

        //act
        Language unit = new English("unit", "единица измерения");
        String resultWord = unit.getWord();
        String resultTranslation = unit.getTranslation();

        //assert
        Assertions.assertEquals(expectedWord, resultWord);
        Assertions.assertEquals(expectedTranslation, resultTranslation);
    }

    @Test
    public void testDeleteWord() throws BadDataException {
        TodosLanguageStorageConnector connector = TodosLanguageStorageConnector.getConnector();

        //arrange
        String expectedResult = "Слово: \"coalesce\", его перевод: \"объединение\"" +
                "\n" +
                "Слово: \"sequences\", его перевод: \"последовательность\"" +
                "\n";

        //act
        connector.addWord("Unit", "Единица измерения", "EN");
        connector.addWord("Coalesce", "Объединение", "EN");
        connector.addWord("Sequences", "Последовательность", "EN");

        connector.removeWord("unit");
        String resultWord = connector.getAllWords();

        //assert
        Assertions.assertEquals(expectedResult, resultWord);
    }

    @Test
    public void testEditWord() throws BadDataException {

        //arrange
        String expectedWord = "unit";
        String expectedTranslation = "единица измерения";

        //act
        Language unit = new English("unit", "ядиницаизмерения");
//        unit.editWord("unit");
        unit.editTranslation("единица измерения");

        String resultWord = unit.getWord();
        String resultTranslation = unit.getTranslation();

        //assert
        Assertions.assertEquals(expectedWord, resultWord);
        Assertions.assertEquals(expectedTranslation, resultTranslation);
    }


}
