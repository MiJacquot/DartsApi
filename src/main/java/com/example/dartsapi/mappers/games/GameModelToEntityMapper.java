package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.entities.ScoreEntity;
import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.Score;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreModelToEntityMapper.scoreModelToEntity;
import static com.example.dartsapi.mappers.users.UserModelToEntityMapper.userModelToEntity;

public class GameModelToEntityMapper {

    public static GameEntity gameModelToEntity(Game game) {
        GameEntity entity = new GameEntity();
        if (game.getId() != null) {
            entity.setId(new ObjectId(game.getId()));
        }
        entity.setUserId(new ObjectId(game.getUserId()));
        entity.setDate(game.getDate());
        List<ScoreEntity> scoreEntityList = new ArrayList<>();
        for (Score score : game.getScores()) {
            scoreEntityList.add(scoreModelToEntity(score));
        }
        entity.setScores(scoreEntityList);
        entity.setNumberOfPlayers(game.getNumberOfPlayers());
        entity.setNumPlayerRound(game.getNumPlayerRound());
        entity.setStatus(game.getStatus());
        return entity;
    }
}
