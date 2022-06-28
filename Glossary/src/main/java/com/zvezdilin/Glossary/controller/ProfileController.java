//package com.zvezdilin.Glossary.controller;
//
//import com.zvezdilin.Glossary.database.postgresQL.Profile;
//import com.zvezdilin.Glossary.database.postgresQL.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.zvezdilin.Glossary.*;
//
//@RestController  //обработчик входящих rest-запросов.
//@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE) //через параметр produces мы указываем, что контроллер возвращает ответ в формате json.
//public class ProfileController {
//
//    private final ProfileService profileService;
//
//    @Autowired
//    public ProfileController(ProfileService profileService) {
//        this.profileService = profileService;
//    }
//
//    @GetMapping(value = "/{personId:\\d+}")  //{personId:\d+} переменная + регулярка
//    public Profile getProfile(@PathVariable int personId) {
//        return profileService.getProfile(personId);
//    }
//}
