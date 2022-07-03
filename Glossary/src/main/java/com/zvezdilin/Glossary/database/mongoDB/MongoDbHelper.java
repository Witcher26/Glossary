package com.zvezdilin.Glossary.database.mongoDB;

import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import org.bson.Document;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDbHelper {

    static Logger LOGGER = Logger.getLogger(MongoDbHelper.class.getName());

    public static Document toDoc(BaseEntity baseEntity) {
        if (baseEntity instanceof English) {
            return new Document(Map.of(
                    "_id", ((Language) baseEntity).getId(),
                    "localDateTime", ((Language) baseEntity).getLocalDateTime(),
                    "locale", ((Language) baseEntity).getLocale(),
                    "word", ((Language) baseEntity).getWord(),
                    "translation", ((Language) baseEntity).getTranslation(),
                    "priority", ((Language) baseEntity).getPriority(),
                    "type", baseEntity.getType()
            ));
        }
        LOGGER.log(Level.WARNING,
                "Exception in method \"tomDoc\"");
        return new Document();
    }

    public static BaseEntity fromDoc(Document document) {
        if (document.get("locale").equals("EN")) {
            int id = (Integer) document.get("_id");
            String localDateTime = (String) document.get("localDateTime");
            String locale = Locale.EN.toString();
            String word = (String) document.get("word");
            String translation = (String) document.get("translation");
            String priority = document.get("priority").toString();
            String type = (String) document.get("type");
            ;
            return new English(id, localDateTime, locale, word, translation, priority, type);
        }
        LOGGER.log(Level.WARNING,
                "Exception in method \"fromDoc\"");
        return new English();
    }
}
