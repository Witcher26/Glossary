package ru.zvezdilin.javacore.myPetProject.todos.interfaces;

public interface ILogger {
    /**
     * Логировоние на участках выполнения программы. Данный экземпляр, также как и хранилище, должно быть единственным
     * на всю программу, поэтому будет реализиовано через паттерн Singleton. Реализация логгера путем добалвения
     * новой строчки в StringBuilder для того, поскольку String - immutable, при каждой операции происходит создание нового String
     * При запросе истории логгирования stringBuilder будет конвертирован в String методом toString();
     */
    void getInfo(String str);
}
