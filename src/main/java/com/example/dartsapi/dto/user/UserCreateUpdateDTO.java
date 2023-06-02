package com.example.dartsapi.dto.user;

import com.example.dartsapi.model.Player;

import java.util.List;

public class UserCreateUpdateDTO {

    public UserCreateUpdateDTO(String username, String password, List<Player> players) {
        this.username = username;
        this.password = password;
        this.players = players;
    }

    public UserCreateUpdateDTO() {
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

    public List<Player> getPlayerIds() {
        return players;
    }

    public void setPlayerIds(List<Player> playerIds) {
        this.players = playerIds;
    }
}
