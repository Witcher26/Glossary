//package com.zvezdilin.Glossary.controller.confing;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//
//// данный класс загружает все настройки с префиксом «mainPool» из файла "application.config"
//@Component
//@ConfigurationProperties(prefix = "mainPool")
//public class ConnectionSettings {
//
//    private static int DEFAULT_MAX_POOL_SIZE = 5;
//
//    private String jdbcDriver;
//    private String jdbcString;
//    private String jdbcUser;
//    private String jdbcPassword;
//    private int jdbcMaxPoolSize = DEFAULT_MAX_POOL_SIZE;
//
//    public static int getDefaultMaxPoolSize() {
//        return DEFAULT_MAX_POOL_SIZE;
//    }
//
//    public static void setDefaultMaxPoolSize(int defaultMaxPoolSize) {
//        DEFAULT_MAX_POOL_SIZE = defaultMaxPoolSize;
//    }
//
//    public String getJdbcDriver() {
//        return jdbcDriver;
//    }
//
//    public void setJdbcDriver(String jdbcDriver) {
//        this.jdbcDriver = jdbcDriver;
//    }
//
//    public String getJdbcString() {
//        return jdbcString;
//    }
//
//    public void setJdbcString(String jdbcString) {
//        this.jdbcString = jdbcString;
//    }
//
//    public String getJdbcUser() {
//        return jdbcUser;
//    }
//
//    public void setJdbcUser(String jdbcUser) {
//        this.jdbcUser = jdbcUser;
//    }
//
//    public String getJdbcPassword() {
//        return jdbcPassword;
//    }
//
//    public void setJdbcPassword(String jdbcPassword) {
//        this.jdbcPassword = jdbcPassword;
//    }
//
//    public int getJdbcMaxPoolSize() {
//        return jdbcMaxPoolSize;
//    }
//
//    public void setJdbcMaxPoolSize(int jdbcMaxPoolSize) {
//        this.jdbcMaxPoolSize = jdbcMaxPoolSize;
//    }
//}
