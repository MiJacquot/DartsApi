package com.example.dartsapi.dto.user;

import com.example.dartsapi.model.Player;

import java.util.List;

public class UserCreateDTO {

    public UserCreateDTO() {
    }

    private String username;

    private String password;

    private List<Player> players;

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
        this.players = playerIds;
    }
}
