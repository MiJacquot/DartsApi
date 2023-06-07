package com.example.dartsapi.mappers.users;

import com.example.dartsapi.entities.UserEntity;
import com.example.dartsapi.model.User;
import com.example.dartsapi.repositories.PlayerRepository;
import org.bson.types.ObjectId;

import static com.example.dartsapi.mappers.players.PayerEntityToPlayerMapper.playerEntityToPlayer;


public class UserEntityToModelMapper {
    private final PlayerRepository playerRepository;

    public UserEntityToModelMapper(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public User userEntityToUser(UserEntity entity) {
        User userToReturn = new User();
        userToReturn.setId(entity.getId().toHexString());
        userToReturn.setUsername(entity.getUsername());
        userToReturn.setPassword(entity.getPassword());
        for (ObjectId id : entity.getPlayerIds()) {
            userToReturn.getPlayers().add(playerEntityToPlayer(this.playerRepository.findOneById(id.toHexString())));
        }
        return userToReturn;
    }
}
