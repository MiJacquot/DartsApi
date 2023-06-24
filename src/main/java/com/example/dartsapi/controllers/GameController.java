package com.example.dartsapi.controllers;

import com.example.dartsapi.dto.game.GameCreateUpdateDTO;
import com.example.dartsapi.dto.game.GameReadDTO;
import com.example.dartsapi.model.Game;
import com.example.dartsapi.model.Score;
import com.example.dartsapi.model.User;
import com.example.dartsapi.services.GameService;
import com.example.dartsapi.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.games.GameDTOToModelMapper.gameCreateDtoToModel;
import static com.example.dartsapi.mappers.games.GameDTOToModelMapper.gameReadDtoToModel;
import static com.example.dartsapi.mappers.games.GameModelToGameDTOMapper.gameModelToDto;

@RestController
public class GameController {

    private final GameService gameService = new GameService();
    private final UserService userService = new UserService();

    @GetMapping(path = "games/list/{username}")
    public List<GameReadDTO> findAll(@PathVariable("username") String username) {
        User loggedUser = userService.getOneByUsername(username);
        List<GameReadDTO> gamesDTO = new ArrayList<>();
        List<Game> games = gameService.findAllByUser(loggedUser.getId());
        games.forEach((game) -> {
            gamesDTO.add(gameModelToDto(game));
        });
        return gamesDTO;
    }

    @PostMapping(path = "games/add")
    public boolean addOneGame(@RequestBody GameCreateUpdateDTO dto) {
        return gameService.addOneGame(gameCreateDtoToModel(dto));
    }

    @PatchMapping(path = "game/{id}")
    public boolean updateOneGame(@RequestBody GameReadDTO dto) {
        return gameService.updateOneGame(gameReadDtoToModel(dto));
    }

}
