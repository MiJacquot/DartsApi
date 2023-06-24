package com.example.dartsapi.mappers.games;

import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.dto.score.ScoreCreateUpdateDTO;
import com.example.dartsapi.mappers.users.UserToDTOMapper;
import com.example.dartsapi.model.Game;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreDtoToModelMapper.scoreCreateDTOToModel;
import static com.example.dartsapi.mappers.scores.ScoreModelToDTO.scoreModelToDTO;
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
        List<ScoreCreateUpdateDTO> scores = new ArrayList<>();
        game.getScores().forEach(score -> {
            scores.add(scoreModelToDTO(score));
        });
        gameDTO.setScores(scores);
        gameDTO.setStatus(game.getStatus());
        gameDTO.setNumberOfPlayers(game.getNumberOfPlayers());
        gameDTO.setNumPlayerRound(game.getNumPlayerRound());
        return gameDTO;
    }
}
