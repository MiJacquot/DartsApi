package com.example.dartsapi.services;


import com.example.dartsapi.dto.user.UserCreateDTO;
import com.example.dartsapi.dto.user.UserReadDTO;
import com.example.dartsapi.entities.UserEntity;
import com.example.dartsapi.mappers.users.UserEntityToModelMapper;
import com.example.dartsapi.model.User;
import com.example.dartsapi.repositories.PlayerRepository;
import com.example.dartsapi.repositories.UserRepository;



import static com.example.dartsapi.mappers.users.UserDTOToUserMapper.createDtoToUser;
import static com.example.dartsapi.mappers.users.UserModelToEntityMapper.userModelToEntity;
import static com.example.dartsapi.mappers.users.UserToDTOMapper.userToReadDTO;

public class UserService {


    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;

    private UserEntityToModelMapper mapper;

    public UserService() {
        this.userRepository = new UserRepository();
        this.playerRepository = new PlayerRepository();
        this.mapper = new UserEntityToModelMapper(playerRepository);
    }

    public User findOneById(String id) {
        UserEntity result = this.userRepository.findOneById(id);
        return mapper.userEntityToUser(result);
    }

    public UserReadDTO addOne(UserCreateDTO dto) {
        UserEntityToModelMapper mapper = new UserEntityToModelMapper(playerRepository);
        User userToAdd = createDtoToUser(dto);
        UserEntity result = this.userRepository.addOne(userModelToEntity(userToAdd));
        User toReturn = mapper.userEntityToUser(result);
       return userToReadDTO(toReturn);
    }

    public boolean addOnePlayerToUser(String userId, String playerId) {
        return userRepository.addOnePlayerToUser(userId, playerId);
    }

    public User getOneByEmail(String email) {
        return mapper.userEntityToUser(userRepository.getUserByEmail(email));
    }

    public boolean authenticate(String username, String password) {
        return userRepository.checkIfUserExists(username, password);
    }


}
