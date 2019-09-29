package Softwe3.WebApiRest_MySql.Controllers;


import Softwe3.WebApiRest_MySql.Database.UserDataAccess;
import Softwe3.WebApiRest_MySql.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/user")

public class UserController {


    @Autowired
    private UserDataAccess userDataAccess;

    @PostMapping("/SetUser")
    public void SetUser(@RequestBody User user){
        userDataAccess.Insert(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userDataAccess.GetAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable String id){
        //---------------------------------------------------------
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Zekiri","Abdelali"));
        users.add(new User(2,"Ali","Aloui"));
        users.add(new User(3,"Raouf","Rahich"));
        //---------------------------------------------------------
        User user = users.stream().filter(u -> u.getId() == Integer.parseInt(id)).findAny().orElse(null);
        return user;
    }

}
