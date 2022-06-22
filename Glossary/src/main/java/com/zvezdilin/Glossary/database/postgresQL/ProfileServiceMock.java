package com.zvezdilin.Glossary.database.postgresQL;

import org.springframework.stereotype.Service;

@Service  //Аннотация @Service используется именно для сервисных компонентов, которые содержат всю бизнес-логику.
// При этом Spring создаст только один экземпляр данного класса
public class ProfileServiceMock implements ProfileService {

    @Override
    public Profile getProfile(int personId) {
        // имитируем обращение к БД
        if (personId == 123) {
            Profile profile = new Profile();
            profile.setId(personId);
            profile.setFirstName("Иван");
            profile.setLastName("Иванов");
            return profile;
        } else {
            throw new ProfileNotFoundException(personId);
        }
    }
}
