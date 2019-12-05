package com.softweb;

//local import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService implements  IUserService{
    private String URL = "http://localhost:58919/api/";
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private IUserDao userDao;

    public UserDto[] GetUsers(){
        String action = "User/GetUsers";
        return  restTemplate.getForObject(URL + action, UserDto[].class);
    }

    public void PostUser(UserDto user) {
        String action = "User/PostUser";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> entity = new HttpEntity<UserDto>(user, headers);
        restTemplate.postForObject(URL + action, entity , UserDto.class);

    }

    public List<UserDto> GetdbUsers() {
        //List<UserDao> users = userDao.findAll();
        //return users.stream().map(u -> convertToDto(u)).collect(Collectors.toList());
        List<UserDto> users = new ArrayList<UserDto>();
        users.add(new UserDto(1,"zekiri","Abdelali"));
       return users;
    }

    public void PostdbUser(UserDto user) {
        //userDao.save(user);
    }
    public void updateUser(UserDto user) {

        //userDao.save(user);
    }
    public Optional<UserDto> GetUserById(int id) {
        //return userDao.findById(id);
        return null;
    }

    public void delUser(int id) {

        //userDao.deleteById(id);
    }
    public List<UserDto> GetUsersByName( String name) {
        //return  userDao.GetUsersByName(name);
        return null;

    }



}