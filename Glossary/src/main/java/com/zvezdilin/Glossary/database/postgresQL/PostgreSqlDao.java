package com.zvezdilin.Glossary.database.postgresQL;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.engine.GlobalRepository;
import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Objects;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSqlDao implements DAO {
    private static final Logger LOGGER = Logger.getLogger(PostgreSqlDao.class.getName());
    private final Map<String, Language> wordsMap;
    private Language nonNullEntity;
    GlobalRepository repository;
    private final String table = "Words";

    public PostgreSqlDao() {
        repository = GlobalRepository.getRepository();
        wordsMap = repository.getWordsMap();
    }

    @Override
    public boolean updateDatabase() {
        String message = "The statement to be added should not be null";

        String sql = "INSERT INTO " + table
                + " (id, localDateTime, word, translation, locale, priority, type) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            /*
            флаг Statement.RETURN_GENERATED_KEYS гарантирует,
            что база данных сообщит о первичном ключе, созданном ею для новой строки
             */

            int numberOfInsertedRows = 0;
            for (Map.Entry<String, Language> storage : wordsMap.entrySet()) {
                nonNullEntity = Objects.requireNonNull(storage.getValue(), message);

                statement.setInt(1, nonNullEntity.getId());
                statement.setString(2, nonNullEntity.getLocalDateTime());
                statement.setString(3, nonNullEntity.getWord());
                statement.setString(4, nonNullEntity.getTranslation());
                statement.setString(5, nonNullEntity.getLocale().toString());
                statement.setString(6, nonNullEntity.getPriority().toString());
                statement.setString(7, nonNullEntity.getType());

                numberOfInsertedRows = statement.executeUpdate();
            }

            LOGGER.log(Level.INFO,
                    "{0} created successfully? {1}",
                    new Object[]{nonNullEntity,
                            (numberOfInsertedRows > 0)});
        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }


    @Override
    public boolean createDatabase() {
        String sql = "CREATE TABLE " + table
                + " (id integer, localDateTime text, word text, translation text, locale text, priority text, type text" +
                ");";

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.executeUpdate();
            LOGGER.log(Level.INFO, "The Table created successfully, count of deleted rows: {0}");

        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }


    @Override
    public boolean readDatabase() {
        Language language = null;
        String sql = "SELECT * FROM " + table;

        try (Connection connection = JdbcConnection.getConnection()) {

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String localDateTime = resultSet.getString("localDateTime");
                    String word = resultSet.getString("word");
                    String translation = resultSet.getString("translation");
                    String locale = resultSet.getString("locale");
                    String priority = resultSet.getString("priority");
                    String type = resultSet.getString("type");

                    if (locale.equalsIgnoreCase("EN")) {
                        language = new English(id, localDateTime, locale, word, translation, priority, type);
                    }
                    repository.addBaseEntity(language);
                    LOGGER.log(Level.INFO, "Found {0} in database", language.getId());
                }
            }

        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDatabase() {
        String sql = "DROP TABLE " + table;

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            int numberOfDeletedRows = statement.executeUpdate();
            LOGGER.log(Level.INFO, "The Table deleted successfully, count of deleted rows: {0}",
                    numberOfDeletedRows > 0);

        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}

