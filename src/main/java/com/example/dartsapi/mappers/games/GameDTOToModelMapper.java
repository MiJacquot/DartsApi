package com.example.dartsapi.mappers.games;

import com.example.dartsapi.dto.game.GameCreateUpdateDTO;
import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.Score;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreDtoToModelMapper.scoreCreateDTOToModel;

public class GameDTOToModelMapper {

    public static Game gameReadDtoToModel(GameReadDTO dto) {
        Game game = new Game();
        if (dto.getId() != null) {
            game.setId(dto.getId());
        }
        game.setUserId(dto.getUserId());
        game.setDate(dto.getDate());
        List<Score> scores = new ArrayList<>();
        dto.getScores().forEach(score -> {
            scores.add(scoreCreateDTOToModel(score));
        });
        game.setScores(scores);
        game.setStatus(dto.getStatus());
        game.setNumberOfPlayers(dto.getNumberOfPlayers());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }

    public static Game gameCreateDtoToModel(GameCreateUpdateDTO dto) {
        Game game = new Game();
        game.setUserId(dto.getUserId());
        game.setDate(dto.getDate());
        List<Score> scores = new ArrayList<>();
        dto.getScores().forEach(score -> {
            scores.add(scoreCreateDTOToModel(score));
        });
        game.setScores(scores);
        game.setStatus(dto.getStatus());
        game.setNumberOfPlayers(dto.getNumberOfPlayers());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }
}
