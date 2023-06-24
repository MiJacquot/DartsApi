package com.example.dartsapi.entities;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class GameEntity {

    public GameEntity(ObjectId id, Date date, List<ScoreEntity> scores, String status, int numPlayerRound) {
        this.id = id;
        this.date = date;
        this.scores = scores;
        this.status = status;
        this.numPlayerRound = numPlayerRound;
    }

    public GameEntity() {
    }

    private ObjectId id;

    private Date date;

    private ObjectId userId;

    private List<ScoreEntity> scores;

    private String status;

    private int numberOfPlayers;

    private int numPlayerRound;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ScoreEntity> getScores() {
        return scores;
    }

    public void setScores(List<ScoreEntity> scores) {
        this.scores = scores;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumPlayerRound() {
        return numPlayerRound;
    }

    public void setNumPlayerRound(int numPlayerRound) {
        this.numPlayerRound = numPlayerRound;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
