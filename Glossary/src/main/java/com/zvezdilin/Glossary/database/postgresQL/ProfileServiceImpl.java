package com.zvezdilin.Glossary.database.postgresQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary   //Если её не указывать, то спринг не сможет заинжектить в ProfileController нужную нам реализацию сервиса, т.к. по факту у нас их дв
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile getProfile(int personId) {
        return profileDao.getProfileById(personId)
                .orElseThrow(() -> new ProfileNotFoundException(personId));
    }
}
