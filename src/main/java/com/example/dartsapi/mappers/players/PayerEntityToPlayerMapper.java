package com.example.dartsapi.mappers.players;

import com.example.dartsapi.entities.PlayerEntity;
import com.example.dartsapi.model.Player;

public class PayerEntityToPlayerMapper {

    public static Player playerEntityToPlayer (PlayerEntity entity) {
        Player player = new Player();
        player.setName(entity.getName());
        player.setId(entity.getId().toHexString());
        return player;
    }
}
