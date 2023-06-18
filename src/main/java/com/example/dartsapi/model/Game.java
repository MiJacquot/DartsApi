package com.example.dartsapi.model;

import java.util.Date;
import java.util.List;

public class Game {

    public Game(String id, Date date, List<Score> scores, String status, int numPlayerRound) {
        this.id = id;
        this.date = date;
        this.scores = scores;
        this.status = status;
        this.numPlayerRound = numPlayerRound;
    }

    public Game() {
    }

    private String id;

    private Date date;

    private User user;

    private List<Score> scores;

    private String status;

    private int numPlayerRound;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
