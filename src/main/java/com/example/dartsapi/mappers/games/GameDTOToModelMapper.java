package com.example.dartsapi.mappers.games;

import com.example.dartsapi.dto.game.GameCreateUpdateDTO;
import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.model.Game;

import static com.example.dartsapi.mappers.users.UserDTOToUserMapper.createDtoToUser;

public class GameDTOToModelMapper {

    public static Game gameReadDtoToModel(GameReadDTO dto) {
        Game game = new Game();
        if (dto.getId() != null) {
            game.setId(dto.getId());
        }
        game.setUser(createDtoToUser(dto.getUserDTO()));
        game.setDate(dto.getDate());
        game.setScores(dto.getScores());
        game.setStatus(dto.getStatus());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }

    public static Game gameCreateDtoToModel(GameCreateUpdateDTO dto) {
        Game game = new Game();
        game.setUser(createDtoToUser(dto.getUserDTO()));
        game.setDate(dto.getDate());
        game.setScores(dto.getScores());
        game.setStatus(dto.getStatus());
        game.setNumPlayerRound(dto.getNumPlayerRound());
        return game;
    }
}
