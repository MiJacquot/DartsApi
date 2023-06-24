package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;

import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.Score;
import com.example.dartsapi.model.User;
import com.example.dartsapi.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreEntityToModelMapper.scoreEntityToModel;


public class GameEntityToModelMappper {

    private static UserService service = new UserService();
        public static Game gameEntityToGame (GameEntity entity) {
            Game game = new Game();
            game.setUserId(entity.getUserId().toHexString());
            game.setId(entity.getId().toHexString());
            List<Score> scores = new ArrayList<>();
            entity.getScores().forEach(scoreEntity -> {
                scores.add(scoreEntityToModel(scoreEntity));
            });
            game.setScores(scores);
            game.setNumPlayerRound(entity.getNumPlayerRound());
            game.setDate(entity.getDate());
            game.setStatus(entity.getStatus());
            return game;
        }
}

