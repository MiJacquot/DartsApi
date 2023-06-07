package com.example.dartsapi.controllers;

import com.example.dartsapi.dto.player.PlayerCreateUpdateDTO;
import com.example.dartsapi.services.PlayerService;
import com.example.dartsapi.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    private final PlayerService playerService;
    private final UserService userService = new UserService();

    public PlayerController() {
        this.playerService = new PlayerService();
    }

    @PostMapping(path = "/players/add/{userId}", consumes = "application/json")
    public boolean addPlayer(@PathVariable("userId") String id, @RequestBody PlayerCreateUpdateDTO dto) {

        String isCreated = playerService.addOne(dto);
        if (isCreated != null) {
            userService.addOnePlayerToUser(id, isCreated);
        }
        return true;
    }

    @DeleteMapping(path = "/players/{id}")
    public boolean deletePlayer(@PathVariable("id") String id) {
        return playerService.deleteOne(id);
    }

}
