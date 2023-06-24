package com.example.dartsapi.mappers.games;

import com.example.dartsapi.dto.game.GameCreateUpdateDTO;
import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.model.Game;

public class GameDTOToModelMapper {

    public static Game gameReadDtoToModel(GameReadDTO dto) {
        Game game = new Game();
        if (dto.getId() != null) {
            game.setId(dto.getId());
        }
        game.setUserId(dto.getUserId());
        game.setDate(dto.getDate());
        game.setScores(dto.getScores());
        game.setStatus(dto.getStatus());
        game.setNumberOfPlayers(dto.getNumberOfPlayers());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }

    public static Game gameCreateDtoToModel(GameCreateUpdateDTO dto) {
        Game game = new Game();
        game.setUserId(dto.getUserId());
        game.setDate(dto.getDate());
        game.setScores(dto.getScores());
        game.setStatus(dto.getStatus());
        game.setNumberOfPlayers(dto.getNumberOfPlayers());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }
}
