package com.zvezdilin.Glossary.databaseApi.postgresQL;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {

    private static final Logger LOGGER = Logger.getLogger(JdbcConnection.class.getName());
    private static Connection connection = null;
    private static final String RESOURCES_PATH = "database.properties";  //файл "database.properties" должен быть в resources

    public static Connection getConnection() throws SQLException, IOException {
        if (connection == null) {
            Properties props = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get(RESOURCES_PATH))) {
                props.load(in);
                String url = props.getProperty("url");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
