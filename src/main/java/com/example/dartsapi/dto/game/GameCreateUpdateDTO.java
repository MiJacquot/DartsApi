package com.example.dartsapi.dto.game;

import com.example.dartsapi.dto.user.UserReadDTO;
import com.example.dartsapi.model.Score;

import java.util.Date;
import java.util.List;

public class GameCreateUpdateDTO {

    public GameCreateUpdateDTO(Date date, List<Score> scores, String status, int numPlayerRound) {
        this.date = date;
        this.scores = scores;
        this.status = status;
        this.numPlayerRound = numPlayerRound;
    }

    public GameCreateUpdateDTO() {
    }

    private Date date;

    private List<Score> scores;

    private UserReadDTO userDTO;

    private String status;

    private int numPlayerRound;

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

    public UserReadDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserReadDTO userDTO) {
        this.userDTO = userDTO;
    }
}
