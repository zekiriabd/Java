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
    public List<User>  getUsers(){
        return userDataAccess.GetAllUsers();
    }

    @GetMapping("/delUser/{id}")
    public int  delUser(@PathVariable  int id){
        return userDataAccess.delUser(id);
    }

    @PostMapping("/delUser")
    public int  updateUser(@RequestBody User user){
        return userDataAccess.updateUser(user);
    }

    @GetMapping("/callUsers")
    public List<User> callUsers(){
        return userDataAccess.callUsers();
    }

    @GetMapping("/CallUser/{id}")
    public String CallUser(@PathVariable  int id){
        return userDataAccess.CallUser(id);
    }







}
