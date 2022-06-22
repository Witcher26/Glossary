package com.zvezdilin.Glossary.database.postgresQL;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(int profileId) {
        super("профиль с указанным id: " + " не найден");
    }
}
