package com.example.dartsapi.dto.user;

import com.example.dartsapi.model.Player;

import java.util.List;

public class UserReadDTO extends UserCreateDTO {

    public UserReadDTO() {
        super();
    }

    public UserReadDTO(String id) {
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
