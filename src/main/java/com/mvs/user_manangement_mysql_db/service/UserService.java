package com.mvs.user_manangement_mysql_db.service;

import com.mvs.user_manangement_mysql_db.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user, Long id);

    void deleteUser(Long id);
}
