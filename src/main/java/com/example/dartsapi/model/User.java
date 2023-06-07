package com.example.dartsapi.model;

import com.example.dartsapi.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class User {

    public User(String id, String username, String password, List<Player> players) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.players = players;
    }





    public User() {
        this.players = new ArrayList<>();
    }

    private String id;

    private String username;

    private String password;

    private List<Player> players;

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> playerIds) {
        this.players = players;
    }
}
