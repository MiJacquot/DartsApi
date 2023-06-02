package com.example.dartsapi.dto.score;

public class ScoreCreateUpdateDTO {

    public ScoreCreateUpdateDTO(String playerName, int score, int numPLayer) {
        this.playerName = playerName;
        this.score = score;
        this.numPLayer = numPLayer;
    }

    public ScoreCreateUpdateDTO() {
    }

    private String playerName;

    private int score;

    private int numPLayer;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumPLayer() {
        return numPLayer;
    }

    public void setNumPLayer(int numPLayer) {
        this.numPLayer = numPLayer;
    }
}
