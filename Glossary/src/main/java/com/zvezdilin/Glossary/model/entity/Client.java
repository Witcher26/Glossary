package com.zvezdilin.Glossary.model.entity;

public class Client implements BaseEntity {
    private String clientID;
    private String type;

    public Client(String clientID) {
        this.clientID = clientID;
        this.type = Client.class.toString();
    }

    public String getType() {
        return type;
    }

    public String getClientID() {
        return clientID;
    }
}