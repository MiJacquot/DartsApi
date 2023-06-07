package com.example.dartsapi.mappers.players;

import com.example.dartsapi.dto.player.PlayerCreateUpdateDTO;
import com.example.dartsapi.model.Player;

public class PlayerDTOToPLayerMapper {

    public static Player playerDTOTOPlayer(PlayerCreateUpdateDTO dto) {
        Player player = new Player();
        player.setName(dto.getName());
        return player;
    }
}
