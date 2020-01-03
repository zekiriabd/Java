package com.example.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService{

    @Autowired
    private IUserDao oUserDao;

    public  String getFullName(){
        String[] userinfo = oUserDao.getDbUser();
        return  userinfo[0] + " _ " + userinfo[1];
    }
}
