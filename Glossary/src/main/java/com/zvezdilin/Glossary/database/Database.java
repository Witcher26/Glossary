package com.zvezdilin.Glossary.database;

import com.zvezdilin.Glossary.model.entity.BaseEntity;
import com.zvezdilin.Glossary.model.entity.Client;

import java.util.List;

public interface Database {
    public boolean createEntity(BaseEntity baseEntity);

    public List<BaseEntity> readEntity();

    public boolean updateEntity(BaseEntity baseEntity);

    public boolean deleteEntity(String word);
}