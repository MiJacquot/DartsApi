package com.example.dartsapi.dto.player;

public class PlayerReadDTO extends PlayerCreateUpdateDTO {

    public PlayerReadDTO(String name, String id) {
        super(name);
        this.id = id;
    }

    public PlayerReadDTO() {
        super();
    }

    public PlayerReadDTO(String id) {
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
