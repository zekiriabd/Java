package com.softweb;

import com.softweb.dto.UserDto;
import com.softweb.mapping.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements  IUserService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserMapper mapper;


    public List<UserDto> GetUsers() {
        List<User> dbusers = userDao.findAll();
        //List<UserDto> users = dbusers.stream().map(u -> new UserDto(u.getId(),u.getFirstName(),u.getLastName()) ).collect(Collectors.toList());

        List<UserDto> users = dbusers.stream().map(mapper::userToUsersDto).collect(Collectors.toList());


        return users;
    }

}