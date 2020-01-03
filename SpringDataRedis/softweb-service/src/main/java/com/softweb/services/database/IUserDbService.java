package com.softweb.services.database;

import com.softweb.dto.UserDto;
import java.util.List;

public interface IUserDbService {
    List<UserDto> getUsers();
    void setUser(UserDto user);
    void updateUser(UserDto user);
    UserDto getUserById(int id);
    void deleteUser(int id);
    List<UserDto> getUsersByName(String name);
}
