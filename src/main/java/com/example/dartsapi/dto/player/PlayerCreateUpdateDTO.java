package com.example.dartsapi.dto.player;

public class PlayerCreateUpdateDTO {

    public PlayerCreateUpdateDTO(String name) {
        this.name = name;
    }

    public PlayerCreateUpdateDTO() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
