package com.example.dartsapi.mappers.users;

import com.example.dartsapi.dto.user.UserCreateUpdateDTO;
import com.example.dartsapi.model.Player;
import com.example.dartsapi.model.User;

public class UserDTOToUserMapper {

    public static User createDtoToUser(UserCreateUpdateDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        for (Player player : dto.getPlayers()) {
            user.getPlayers().add(player);
        }
        return user;
    }
}
