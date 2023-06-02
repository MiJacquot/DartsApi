package com.example.dartsapi.dto.score;

public class ScoreReadDTO extends ScoreCreateUpdateDTO {

    public ScoreReadDTO(String playerName, int score, int numPLayer, String id) {
        super(playerName, score, numPLayer);
        this.id = id;
    }

    public ScoreReadDTO() {
        super();
    }

    public ScoreReadDTO(String id) {
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
