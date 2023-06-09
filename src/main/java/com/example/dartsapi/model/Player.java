package com.example.dartsapi.model;

import org.bson.types.ObjectId;

public class Player {

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
    }

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
