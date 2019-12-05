package com.softweb;

import com.softweb.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    UserDto[] GetUsers();
    void PostUser(UserDto user);

    List<UserDto> GetdbUsers();
    void PostdbUser(UserDto user);
    void updateUser(UserDto user);
    Optional<UserDto> GetUserById(int id);
    void delUser(int id);
    List<UserDto> GetUsersByName(String name);

}
