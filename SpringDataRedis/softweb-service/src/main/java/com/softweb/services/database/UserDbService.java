package com.softweb.services.database;


import com.softweb.IUserDao;
import com.softweb.User;
import com.softweb.dto.UserDto;
import com.softweb.mapping.IUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserDbService implements IUserDbService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserMapper mapper;

    public List<UserDto> getUsers() {
        List<User> dbusers = userDao.findAll();
        List<UserDto> users = dbusers.stream().map(mapper::userToUsersDto).collect(Collectors.toList());
        return users;
    }

    public void setUser(UserDto user) {
        User newUser = mapper.userDtoToUsers(user);
        userDao.save(newUser);
    }

    public void updateUser(UserDto user) {
        User newUser = mapper.userDtoToUsers(user);
        userDao.save(newUser);
    }

    public UserDto getUserById(int id) {
        Optional<User> user = userDao.findById(id);
        return user == null? new UserDto() : mapper.userToUsersDto(user.get());
    }

    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
    public List<UserDto> getUsersByName( String name) {
        List<User> dbusers =  userDao.GetUsersByName(name);
        List<UserDto> users = dbusers.stream().map(mapper::userToUsersDto).collect(Collectors.toList());
        return users;
    }

}