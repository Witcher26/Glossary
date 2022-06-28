//package com.zvezdilin.Glossary.database.postgresQL;
//
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class ProfileMapper implements RowMapper<Profile> {
//
//    @Override
//    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Profile profile = new Profile();
//        profile.setId(rs.getInt("id"));
//        profile.setFirstName(rs.getString("first_name"));
//        profile.setLastName(rs.getString("last_name"));
//        profile.setAge(rs.getInt("age"));
//        return profile;
//    }
//}
