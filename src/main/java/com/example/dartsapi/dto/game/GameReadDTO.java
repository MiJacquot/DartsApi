package com.example.dartsapi.dto.game;

import com.example.dartsapi.dto.score.ScoreCreateUpdateDTO;
import com.example.dartsapi.model.Score;

import java.util.Date;
import java.util.List;

public class GameReadDTO extends GameCreateUpdateDTO {

    public GameReadDTO(Date date, List<ScoreCreateUpdateDTO> scores, String status, int numPlayerRound, String id) {
        super(date, scores, status, numPlayerRound);
        this.id = id;
    }

    public GameReadDTO() {
        super();
    }

    public GameReadDTO(String id) {
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
