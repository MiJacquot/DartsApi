package com.example.dartsapi.model;

public class Score {

    public Score(String id, String playerName, int score, int numPLayer) {
        this.id = id;
        this.playerName = playerName;
        this.score = score;
        this.numPLayer = numPLayer;
    }

    public Score() {
    }

    private String id;

    private String playerName;

    private int score;

    private int numPLayer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
