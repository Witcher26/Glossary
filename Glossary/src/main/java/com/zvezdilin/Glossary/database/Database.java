package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.model.engine.Storage;
import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Client;

import java.util.List;

public interface Database {
    public boolean createDatabase();

    public boolean readDatabase();

    public boolean updateDatabase();

    public boolean deleteDatabase();
}
