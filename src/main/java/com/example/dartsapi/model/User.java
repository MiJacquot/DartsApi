package com.example.dartsapi.model;

import java.util.List;

public class User {

    public User(String id, String username, String password, List<Player> playerIds) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.playerIds = playerIds;
    }

    public User() {
    }

    private String id;

    private String username;

    private String password;

    private List<Player> playerIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Player> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Player> playerIds) {
        this.playerIds = playerIds;
    }
}
