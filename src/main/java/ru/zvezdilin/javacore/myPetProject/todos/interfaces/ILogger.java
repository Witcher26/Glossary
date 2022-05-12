package ru.zvezdilin.javacore.myPetProject.todos.interfaces;

public interface ILogger {
    /**
     * Логировоние на участках выполнения программы. Данный экземпляр, также как и хранилище тасков, должно быть единственным
     * на всю программу, поэтому будет реализиовано через паттерн Singleton. Сам логгер был реалзиовано путем добалвения
     * новой строчки в StringBuilder, для того, чтобы не создавать каждый раз заново String.
     * При запросе истории логгирования stringBuilder будет конвертирован в String методом toString();
     *
     */
    void append(String str);
}
