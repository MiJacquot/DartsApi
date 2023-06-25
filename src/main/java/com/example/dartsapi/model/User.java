package com.example.dartsapi.model;

import com.example.dartsapi.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class User {

    public User(String id, String email, String password, List<Player> players) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.players = players;
    }





    public User() {
        this.players = new ArrayList<>();
    }

    private String id;

    private String email;

    private String password;

    private List<Player> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
