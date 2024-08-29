package com.mvs.user_management_mysql_db.mapper;

import com.mvs.user_management_mysql_db.dto.UserDto;
import com.mvs.user_management_mysql_db.entity.User;

public class UserMapper {

    public static User mapUserDtoToUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAge());
    }

    public static UserDto mapUserToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge());
    }
}
