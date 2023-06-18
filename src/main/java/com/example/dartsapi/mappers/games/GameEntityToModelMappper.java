package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;

import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.Score;
import com.example.dartsapi.model.User;
import com.example.dartsapi.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreEntityToModelMapper.scoreModelToEntity;

public class GameEntityToModelMappper {

    private static UserService service = new UserService();
        public static Game gameEntityToGame (GameEntity entity) {
            Game game = new Game();
            User userToAdd = service.findOneById(entity.getUserEntity().getId().toHexString());
            game.setUser(userToAdd);
            game.setId(entity.getId().toHexString());
            List<Score> scores = new ArrayList<>();
            entity.getScores().forEach(scoreEntity -> {
                scores.add(scoreModelToEntity(scoreEntity));
            });
            game.setScores(scores);
            game.setNumPlayerRound(entity.getNumPlayerRound());
            game.setDate(entity.getDate());
            game.setStatus(entity.getStatus());
            return game;
        }
}

