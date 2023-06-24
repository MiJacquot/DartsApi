package com.example.dartsapi.services;

import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.User;
import com.example.dartsapi.repositories.GameRepository;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.games.GameEntityToModelMappper.gameEntityToGame;
import static com.example.dartsapi.mappers.games.GameModelToEntityMapper.gameModelToEntity;
import static com.example.dartsapi.mappers.users.UserModelToEntityMapper.userModelToEntity;

public class GameService {

    private final GameRepository gameRepository = new GameRepository();

    public List<Game> findAllByUser(String userId) {
        List<Game> games = new ArrayList<>();
        List<GameEntity> gamesEntities = gameRepository.findAllByUserId(new ObjectId(userId));
        gamesEntities.forEach((gameEntity) -> {
            games.add(gameEntityToGame(gameEntity));
        });
        return games;
    }
    public boolean addOneGame(Game game) {
        ObjectId result = gameRepository.addOne(gameModelToEntity(game));
        return result != null;
    }

    public boolean updateOneGame(Game game) {
        return gameRepository.updateOneGame(gameModelToEntity(game));
    }
}
