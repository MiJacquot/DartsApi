package com.example.dartsapi.entities;

import org.bson.types.ObjectId;

public class PlayerEntity {

    public PlayerEntity(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerEntity() {
    }

    private ObjectId id;

    private String name;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
