package com.example.dartsapi.mappers.users;
import com.example.dartsapi.entities.UserEntity;
import com.example.dartsapi.model.Player;
import com.example.dartsapi.model.User;
import org.bson.types.ObjectId;


public class UserModelToEntityMapper {

    public static UserEntity userModelToEntity(User user) {
        UserEntity entity = new UserEntity();
        if (user.getId() != null) {
            entity.setId(new ObjectId(user.getId()));
        }
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        for (Player player : user.getPlayers()) {
            entity.getPlayerIds().add(new ObjectId(player.getId()));
        }
        return entity;
    }
}
