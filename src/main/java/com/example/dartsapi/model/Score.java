package com.example.dartsapi.model;

public class Score {

    public Score(String id, String playerName, int score, int numPlayer) {
        this.id = id;
        this.playerName = playerName;
        this.score = score;
        this.numPlayer = numPlayer;
    }

    public Score() {
    }

    private String id;

    private String playerName;

    private int score;

    private int numPlayer;

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

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }
}
