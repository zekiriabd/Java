package com.example.DependencyInjection;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUserDao{
    public String[] getDbUser(){
       /*الاتصال بالقاعدة و جلب البيانات*/
        String[] result = {"Zekiri","Abdelali"};
        return result;
    }

    public UserDao(){
        System.out.println("تم الانشاء");
    }
}
