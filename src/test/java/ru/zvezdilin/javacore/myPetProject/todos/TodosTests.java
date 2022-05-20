package ru.zvezdilin.javacore.myPetProject.todos;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosLanguageStorageAdapter;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TodosTests {

    Map<String, Language> storage = new HashMap<>();
    TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
    Todos todos = new Todos(adapter);

//    Map<String, Language> staticStorages(){

    static Todos staticStorages() {
        Map<String, Language> storage = new HashMap<>();
        TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
        Todos todos = new Todos(adapter);

        todos.addTask(new English("related", "связанный"));
        todos.addTask(new English("Unit", "единица измерения"));
        return todos;
    }


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
    public void testCheckTodoAddTask() {
        //arrange
        String expected = "unit\n";

        //act
        todos.addTask(new English("Unit", "единица измерения"));
        String result = todos.getAllTasks();

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @ParameterizedTest
    @MethodSource("staticStorages")
    public void testRemoveTask(Todos todos) {
        Language related = new English("related", "связанный");
        todos.addTask(related);
        todos.addTask(new English("Unit", "единица измерения"));

        todos.removeTask(related);

        String result = todos.getAllTasks();


        Assertions.assertEquals("unit", result);


    }


//    static Map<String, Language> addAllTask(){
//
//    }
//
//    @ParameterizedTest
//    @MethodSource("TestSource")
//    public void testParCheckWithSource(int year, int days, boolean expected) {
//        boolean result = checkYear.checkYear(year, days);
//        Assertions.assertEquals(expected, result);
//    }
//
//    private static Stream<Arguments> TestSource() {
//        return Stream.of(
//                Arguments.of(1764, 366, true),
//                Arguments.of(2013, 365, true)
//        );
//    }
}
