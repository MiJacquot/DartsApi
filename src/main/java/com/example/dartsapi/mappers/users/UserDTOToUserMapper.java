package com.example.dartsapi.mappers.users;

import com.example.dartsapi.dto.user.UserCreateDTO;
import com.example.dartsapi.model.Player;
import com.example.dartsapi.model.User;

public class UserDTOToUserMapper {

    public static User createDtoToUser(UserCreateDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        for (Player player : dto.getPlayers()) {
            user.getPlayers().add(player);
        }
        return user;
    }
}
