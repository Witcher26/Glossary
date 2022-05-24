//package ru.zvezdilin.javacore.myPetProject.todos;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import ru.zvezdilin.javacore.myPetProject.todos.classes.Todos;
//import ru.zvezdilin.javacore.myPetProject.todos.classes.TodosLanguageStorageAdapter;
//import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.English;
//import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Stream;
//
//public class TodosTests {
//
//    Map<String, Language> storage = new HashMap<>();
//    TodosLanguageStorageAdapter adapter = new TodosLanguageStorageAdapter(storage);
//    Todos todos = new Todos(adapter);
//
//
//    static Language[] staticStorageWords() {
//        return new Language[]{new English("related", "связанный")};
//    }
//
//
//    @BeforeAll
//    public static void beforeAllMethod() {
//        System.out.println("BeforeAll call");
//    }
//
//    @BeforeEach
//    public void beforeEachMethod() {
//        System.out.println("BeforeEach call");
//    }
//
//    @AfterEach
//    public void afterEachMethod() {
//        System.out.println("AfterEach call");
//    }
//
//    @AfterAll
//    public static void afterAllMethod() {
//        System.out.println("AfterAll call");
//    }
//
//
//    @Test
//    public void testCheckTodoAddTask() {
//        //arrange
//        String expected = "unit\n";
//
//        //act
//        todos.addTask(new English("Unit", "единица измерения"));
//        String result = todos.getAllTasks();
//
//        //assert
//        Assertions.assertEquals(expected, result);
//    }
//
//
////    @Test
////    @ParameterizedTest
////    @MethodSource("staticStorageWords")
////    public void testRemoveTask(Language word) {
////        //arrange
////        todos.addTask(word);
//////        Language related = new English("related", "связанный");
////
////        //act
////        todos.removeTask(new English("related", "связанный"));
////
////        String result = todos.getAllTasks();
////
////        //assert
////        Assertions.assertEquals("Слова отсутствуют", result);
////    }
////
////
////    //    static Map<String, Language> addAllTask(){
//////
//////    }
////
//    @ParameterizedTest
//    @MethodSource("TestSource")
//    public void testCheckAddTaskWithSource(Language word) {
//        todos.addTask(word);
//        String result = todos.getAllTasks();
//        String expected = word.getWord().toLowerCase() + "\n";
//        Assertions.assertEquals(expected, result);
//    }
//
//    private static Stream<Arguments> TestSource() {
//        return Stream.of(
//                Arguments.of(new English("related", "связанный")),
//                Arguments.of(new English("Unit", "единица измерения")),
//                Arguments.of(new English("Terminate", "завершать"))
//        );
//    }
//}
