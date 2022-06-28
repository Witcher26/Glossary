//package com.zvezdilin.Glossary.database.postgresQL;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class ProfileDaoImpl implements ProfileDao {
//
//    private static final String SQL_GET_PROFILE_BY_ID =
//            "select id, first_name, last_name, age from profiles where id = :id";
//
//    private final ProfileMapper profileMapper;
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public ProfileDaoImpl(
//            ProfileMapper profileMapper, //ProfileMapper преобразует данные, полученные из БД в объект Profile
//            NamedParameterJdbcTemplate jdbcTemplate //NamedParameterJdbcTemplate - стандартный компонент, предоставляющий методы для взаимодействия с БД, поддерживает именованные параметр
//    ) {
//        this.profileMapper = profileMapper;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Optional<Profile> getProfileById(int id) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);
//        try {
//            return Optional.ofNullable(
//                    jdbcTemplate.queryForObject(
//                            SQL_GET_PROFILE_BY_ID,
//                            params,
//                            profileMapper
//                    )
//            );
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
//    }
//}
