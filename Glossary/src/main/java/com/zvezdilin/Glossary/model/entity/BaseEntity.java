package com.zvezdilin.Glossary.model.entity;

/**
 * Передача в параметры методов объеков, которые поддерживают интерфейс BaseEntity.
 */
public interface BaseEntity {
    /**
     *  метод получения информации о принадлежности к классу
     * @return this.getClass().toString();
     */
    String getType();
}
