package com.example.dartsapi.services;

import com.example.dartsapi.dto.player.PlayerCreateUpdateDTO;
import com.example.dartsapi.model.Player;
import com.example.dartsapi.repositories.PlayerRepository;

import java.util.List;

import static com.example.dartsapi.mappers.players.PlayerDTOToPLayerMapper.playerDTOTOPlayer;
import static com.example.dartsapi.mappers.players.PlayerToPlayerEntityMapper.playerToPlayerEntity;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService() {
        this.playerRepository = new PlayerRepository();
    }

    public String addOne(PlayerCreateUpdateDTO dto) {
        Player player = playerDTOTOPlayer(dto);
        return playerRepository.addOne(playerToPlayerEntity(player)).toHexString();
    }

    public boolean deleteOne(String id) {
        return playerRepository.deleteOne(id);
    }
}
