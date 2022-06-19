package com.zvezdilin.Glossary.database.mongoDB;

import com.zvezdilin.Glossary.model.config.Locale;
import com.zvezdilin.Glossary.model.config.Priority;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Client;
import com.zvezdilin.Glossary.model.entity.English;
import com.zvezdilin.Glossary.model.entity.Language;
import org.bson.Document;

import java.util.Map;
import java.util.logging.Logger;

public class DatabaseHelper {

    static Logger logger = Logger.getLogger("DataBaseHelper");

    public static Document toDoc(BaseEntity baseEntity) {
        if (baseEntity instanceof Language) {
            return new Document(Map.of(
                    "_id", ((Language) baseEntity).getId(),
                    "localDateTime", ((Language) baseEntity).getLocalDateTime(),
                    "word", ((Language) baseEntity).getWord(),
                    "translation", ((Language) baseEntity).getTranslation(),
                    "locale", ((Language) baseEntity).getLocale(),
                    "priority", ((Language) baseEntity).getPriority(),
                    "type", ((Language) baseEntity).getType()
            ));
        }

        if (baseEntity instanceof Client) { // TODO client ???
            return new Document(Map.of(
                    "clientID", ((Client) baseEntity).getClientID(),
                    "type", ((Client) baseEntity).getType()
            ));
        }
        return null;
    }

    public static BaseEntity fromDoc(Document document) {
        if (document.get("type").equals("EN")) {
            String localDateTime = (String) document.get("localDateTime");
            String word = (String) document.get("word");
            String translation = (String) document.get("translation");
            Locale locale = Locale.EN;
            Priority priority = (Priority.getValue(document.get("priority").toString()));
            return new English(localDateTime, locale, word, translation, priority);
        }
        return null;
    }
}