package com.mvs.user_manangement_mysql_db.service.impl;

import com.mvs.user_manangement_mysql_db.dto.UserDto;
import com.mvs.user_manangement_mysql_db.entity.User;
import com.mvs.user_manangement_mysql_db.mapper.UserMapper;
import com.mvs.user_manangement_mysql_db.repository.UserRepository;
import com.mvs.user_manangement_mysql_db.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    // In Spring 4.3 onwards we need not inject the dependencies
    // using @Autowired for constructor that has single instance
    // or single parameter
    // The @AllArgsConstructor is used to have the constructor
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userdto) {
        User userToBeCreated = UserMapper.mapUserDtoToUser(userdto);
        User userCreated = userRepository.save(userToBeCreated);
        return UserMapper.mapUserToUserDto(userCreated);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUserById = userRepository.findById(userId);
        User user = optionalUserById.orElse(null);
        assert user != null;
        return UserMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> allUsers = userRepository.findAll();
//        for (User user: allUsers) {
//            UserDto userDto = UserMapper.mapUserToUserDto(user);
//            userDtos.add(userDto);
//        }
//        return userDtos;
        return allUsers.stream().map(UserMapper::mapUserToUserDto).toList();
    }


    @Override
    public UserDto updateUser(UserDto userDto, Long id) {\
        UserDto existingUser = getUserById(id);
        existingUser.setId(id);
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(existingUser.getEmail());
        existingUser.setAge(existingUser.getAge());
        User userToBeUpdated = UserMapper.mapUserDtoToUser(existingUser);
        User updatedUser = userRepository.save(userToBeUpdated);
        return UserMapper.mapUserToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
