package ru.zvezdilin.javacore.myPetProject.todos.interfaces;

import ru.zvezdilin.javacore.myPetProject.todos.languageObjects.Language;

public interface IStorage {
    /**
     * Добавление задач в хранилище. Хралище должно быть в одном
     * экземпляре. Для этого используется паттерн Singleton, объект которого будет создать
     * единственное хранилище на всю программу. Создаваться оно будет вызов конструктора, параметры которого
     * будут реализовывать интерфейс IStorage.
     *
     * Само хранилище предпологается хранить в поле List<String> объекта, который будет реализовывать
     * интерфейс IStorage. Для реалзиации предпологаетя применение паттерна Adapter.
     *
     * @throws IOException при введении неверных данных??
     *
     */
    void addTask(Language task);

    /**
     *Удаление задач из хранилища. При отсутствии задач вывод сообщения или своего собественного искл.
     */

    void removeTask(Language task);

    /**
     * Вывод всех задач (даже если список пустой - извещение об этом).
     * @return собранную строку (посредством SB)
     */

    String getAllTasks();
}
