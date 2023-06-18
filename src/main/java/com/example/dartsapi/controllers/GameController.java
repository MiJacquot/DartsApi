package com.example.dartsapi.controllers;

import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.services.GameService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.dartsapi.mappers.games.GameDTOToModelMapper.gameDtoToModel;

@RestController
public class GameController {

    private final GameService gameService = new GameService();

    @PostMapping(path = "games/add")
    public boolean addOneGame(@RequestBody GameReadDTO dto) {
        return gameService.addOneGame(gameDtoToModel(dto));
    }

    @PatchMapping(path = "game/{id}")
    public boolean updateOneGame(@RequestBody GameReadDTO dto) {
        return gameService.updateOneGame(gameDtoToModel(dto));
    }

}
