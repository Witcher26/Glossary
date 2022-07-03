package com.zvezdilin.Glossary.database;

/**
 * Data Access Object - модуль доступа к данным
 */
public interface DAO {

    /**
     * метод создания базы данных
     *
     * @return true or false
     */
    public boolean createDatabase();

    /**
     * метод получения информации из базы данных в GlobalRepository
     *
     * @return true or false
     */
    public boolean readDatabase();

    /**
     * метод обновления созданной базы данных данными из GlobalRepository
     *
     * @return true or false
     */
    public boolean updateDatabase();

    /**
     * метод удаления базы данных
     *
     * @return true or false
     */
    public boolean deleteDatabase();
}
