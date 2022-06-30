package com.zvezdilin.Glossary.database.postgresQL;

import com.zvezdilin.Glossary.database.DAO;
import com.zvezdilin.Glossary.engine.TodosConnector;
import com.zvezdilin.Glossary.model.entity.Language;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Objects;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSqlDao implements DAO {
    private static final Logger LOGGER = Logger.getLogger(PostgreSqlDao.class.getName());
    private Map<String, Language> wordsMap;
    //    private static Optional connection;
    private Language nonNullEntity;

    public PostgreSqlDao() {
        TodosConnectorVO connector = new TodosConnectorVO();
        wordsMap = connector.getWordsMapFromConnector();
    }

    @Override
    public boolean updateDatabase() {
        String message = "The statement to be added should not be null";

        String sql = "INSERT INTO "
                + "Words(id, localDateTime, word, translation, locale, priority, type) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            /*
            флаг Statement.RETURN_GENERATED_KEYS гарантирует,
            что база данных сообщит о первичном ключе, созданном ею для новой строки
             */

            for (Map.Entry<String, Language> storage : wordsMap.entrySet()) {
                nonNullEntity = Objects.requireNonNull(storage.getValue(), message);

                statement.setInt(1, nonNullEntity.getId());
                statement.setString(2, nonNullEntity.getLocalDateTime());
                statement.setString(3, nonNullEntity.getWord());
                statement.setString(3, nonNullEntity.getTranslation());
                statement.setString(3, nonNullEntity.getLocale().toString());
                statement.setString(3, nonNullEntity.getPriority().toString());
                statement.setString(3, nonNullEntity.getType());
            }

            int numberOfInsertedRows = statement.executeUpdate();
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


//    public Customer get(int id) {
//        Customer customer = null;
//        String sql = "SELECT * FROM customer WHERE customer_id = " + id;
//
//        try (Connection connection = JdbcConnection.getConnection()) {
//
//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet = statement.executeQuery(sql)) {
//
//                if (resultSet.next()) {
//                    String firstName = resultSet.getString("first_name");
//                    String lastName = resultSet.getString("last_name");
//                    String email = resultSet.getString("email");
//
//                    customer = new Customer(id, firstName, lastName, email);
//
//                    LOGGER.log(Level.INFO, "Found {0} in database", customer.getId());
//                }
//            }
//
//        } catch (SQLException | IOException ex) {
//            LOGGER.log(Level.SEVERE, null, ex);
//        }
//        return customer;
//    }


    @Override
    public boolean createDatabase() {
        return true;
    }

    @Override
    public boolean readDatabase() {
        return true;
    }

    @Override
    public boolean deleteDatabase() {
        return true;
    }

//    public void update(Customer customer) {
//        String message = "The customer to be updated should not be null";
//        Customer nonNullCustomer = Objects.requireNonNull(customer, message);
//        String sql = "UPDATE customer "
//                + "SET "
//                + "first_name = ?, "
//                + "last_name = ?, "
//                + "email = ? "
//                + "WHERE "
//                + "customer_id = ?";
//
//        connection.ifPresent(conn -> {
//            try (PreparedStatement statement = conn.prepareStatement(sql)) {
//
//                statement.setString(1, nonNullCustomer.getFirstName());
//                statement.setString(2, nonNullCustomer.getLastName());
//                statement.setString(3, nonNullCustomer.getEmail());
//                statement.setInt(4, nonNullCustomer.getId());
//
//                int numberOfUpdatedRows = statement.executeUpdate();
//
//                LOGGER.log(Level.INFO, "Was the customer updated successfully? {0}",
//                        numberOfUpdatedRows > 0);
//
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, null, ex);
//            }
//        });
//    }
//
//    public void delete(Customer customer) {
//        String message = "The customer to be deleted should not be null";
//        Customer nonNullCustomer = Objects.requireNonNull(customer, message);
//        String sql = "DELETE FROM customer WHERE customer_id = ?";
//
//        connection.ifPresent(conn -> {
//            try (PreparedStatement statement = conn.prepareStatement(sql)) {
//
//                statement.setInt(1, nonNullCustomer.getId());
//
//                int numberOfDeletedRows = statement.executeUpdate();
//
//                LOGGER.log(Level.INFO, "Was the customer deleted successfully? {0}",
//                        numberOfDeletedRows > 0);
//
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, null, ex);
//            }
//        });
//    }


}

