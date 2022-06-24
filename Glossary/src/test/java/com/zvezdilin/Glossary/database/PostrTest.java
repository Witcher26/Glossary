package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.controller.confing.ConnectionSettings;
import com.zvezdilin.Glossary.controller.confing.DatabaseConfig;
import com.zvezdilin.Glossary.database.postgresQL.ProfileDao;
import com.zvezdilin.Glossary.database.postgresQL.ProfileDaoImpl;
import com.zvezdilin.Glossary.database.postgresQL.ProfileMapper;
import com.zvezdilin.Glossary.database.postgresQL.ProfileServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PostrTest {
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
    public void testCreatePost() {

//        ConnectionSettings settings = new ConnectionSettings();
//        DatabaseConfig databaseConfig = new DatabaseConfig(settings);
//        ProfileMapper profileMapper = new ProfileMapper();
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(databaseConfig.dataSource());
//        ProfileDao profileDao = new ProfileDaoImpl(profileMapper, namedParameterJdbcTemplate);
//        ProfileServiceImpl profileService = new ProfileServiceImpl(profileDao);
//
//        profileDao.getProfileById(1);
    }

}
