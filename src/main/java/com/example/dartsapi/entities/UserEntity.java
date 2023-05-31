package com.example.dartsapi.entities;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {

    public UserEntity(ObjectId id, String username, String password) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.playerIds = new ArrayList<>();
    }

    public UserEntity() {
    }

    private ObjectId id;

    private String username;

    private String password;

    private List<ObjectId> playerIds;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ObjectId> getPlayers() {
        return playerIds;
    }

    public void setPlayers(List<ObjectId> playerIds) {
        this.playerIds = playerIds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
