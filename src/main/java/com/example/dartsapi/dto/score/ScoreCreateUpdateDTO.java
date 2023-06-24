package com.example.dartsapi.dto.score;

public class ScoreCreateUpdateDTO {

    public ScoreCreateUpdateDTO(String playerName, int score, int numPLayer) {
        this.playerName = playerName;
        this.score = score;
        this.numPlayer = numPLayer;
    }

    public ScoreCreateUpdateDTO() {
    }

    private String playerName;

    private int score;

    private int numPlayer;

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

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPLayer) {
        this.numPlayer = numPLayer;
    }
}
