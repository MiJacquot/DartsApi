package com.example.dartsapi.entities;

import org.bson.types.ObjectId;

public class ScoreEntity {

    public ScoreEntity(ObjectId id, String playerName, int score, int numPlayer) {
        this.id = id;
        this.playerName = playerName;
        this.score = score;
        this.numPlayer = numPlayer;
    }

    public ScoreEntity() {
    }

    private ObjectId id;

    private String playerName;

    private int score;

    private int numPlayer;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public void setNumPlayer(int numPLayer) {
        this.numPlayer = numPLayer;
    }
}
