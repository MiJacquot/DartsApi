package com.example.dartsapi.mappers.games;

import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.mappers.users.UserToDTOMapper;
import com.example.dartsapi.model.Game;

import static com.example.dartsapi.mappers.users.UserDTOToUserMapper.createDtoToUser;
import static com.example.dartsapi.mappers.users.UserToDTOMapper.userToReadDTO;

public class GameModelToGameDTOMapper {

    public static GameReadDTO gameModelToDto(Game game) {
        GameReadDTO gameDTO = new GameReadDTO();
        if (game.getId() != null) {
            game.setId(game.getId());
        }
        gameDTO.setUserId(game.getUserId());
        gameDTO.setDate(game.getDate());
        gameDTO.setScores(game.getScores());
        gameDTO.setStatus(game.getStatus());
        gameDTO.setNumPlayerRound(game.getNumPlayerRound());
        return gameDTO;
    }
}
