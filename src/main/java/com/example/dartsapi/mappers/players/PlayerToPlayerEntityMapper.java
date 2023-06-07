package com.example.dartsapi.mappers.players;

import com.example.dartsapi.entities.PlayerEntity;
import com.example.dartsapi.model.Player;
import org.bson.types.ObjectId;

public class PlayerToPlayerEntityMapper {

    public static PlayerEntity playerToPlayerEntity(Player player) {
        PlayerEntity playerEntity = new PlayerEntity();
        if (player.getId() != null) {
            playerEntity.setId(new ObjectId(player.getId()));
        }
        playerEntity.setName(player.getName());
        return playerEntity;
    }
}
