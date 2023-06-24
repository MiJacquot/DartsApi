package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.dto.score.ScoreCreateUpdateDTO;
import com.example.dartsapi.model.Score;

public class ScoreModelToDTO {

    public static ScoreCreateUpdateDTO scoreModelToDTO(Score score) {
        ScoreCreateUpdateDTO scoreDto = new ScoreCreateUpdateDTO();
        scoreDto.setScore(score.getScore());
        scoreDto.setNumPlayer(score.getNumPlayer());
        scoreDto.setPlayerName(score.getPlayerName());
        return scoreDto;
    }
}
