package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.dto.game.GameCreateUpdateDTO;
import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.dto.score.ScoreCreateUpdateDTO;
import com.example.dartsapi.dto.score.ScoreReadDTO;
import com.example.dartsapi.entities.ScoreEntity;
import com.example.dartsapi.model.Score;

public class ScoreDtoToModelMapper {

    public static Score scoreCreateDTOToModel(ScoreCreateUpdateDTO dto) {
        Score score = new Score();
        score.setScore(dto.getScore());
        score.setNumPlayer(dto.getNumPlayer());
        score.setPlayerName(dto.getPlayerName());
        return score;
    }

    public static Score scoreReadToModel(ScoreReadDTO dto) {
        Score score = new Score();
        score.setId(dto.getId());
        score.setScore(dto.getScore());
        score.setNumPlayer(dto.getNumPlayer());
        score.setPlayerName(dto.getPlayerName());
        return score;
    }
}
