package com.softweb.mapping;

import com.softweb.dto.UserDto;
import com.softweb.User;
import org.mapstruct.Mapper;

@Mapper
public interface IUserMapper {
    UserDto userToUsersDto(User user);
    User userDtoToUsers(UserDto userDto);
}
