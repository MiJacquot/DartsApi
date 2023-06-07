package com.example.dartsapi.mappers.users;

import com.example.dartsapi.dto.user.UserReadDTO;
import com.example.dartsapi.model.User;

public class UserToDTOMapper {

    public static UserReadDTO userToReadDTO(User user) {
        UserReadDTO dto = new UserReadDTO();
        dto.setId(user.getId());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setPlayers(user.getPlayers());
        return dto;
    }
}
