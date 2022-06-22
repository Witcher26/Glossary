package com.zvezdilin.Glossary.database.postgresQL;

import java.util.Optional;

public interface ProfileDao {  //Для работы с БД принято выделять отдельной слой dao (data access object - объект доступа к данным)
    Optional<Profile> getProfileById(int id);
}
