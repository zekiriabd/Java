package Softwe3.WebApiRest_JPA_MySql.Controllers;


import Softwe3.WebApiRest_JPA_MySql.Database.IUserDataAccess;
import Softwe3.WebApiRest_JPA_MySql.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserDataAccess userDataAccess;

    @GetMapping("/GetUsers")
    public List<User> GetUsers() {
        return userDataAccess.findAll();
    }

    @PostMapping("/PostUser")
    public void PostUser(@RequestBody User user) {
        userDataAccess.save(user);
    }

    @PostMapping("/UpdateUser")
    public void updateUser(@RequestBody User user) {
        userDataAccess.save(user);
    }

    @GetMapping("/GetUserById/{id}")
    public Optional<User> GetUserById(@PathVariable int id) {
        return userDataAccess.findById(id);
    }

    @GetMapping("/delUser/{id}")
    public void delUser(@PathVariable int id) {
        userDataAccess.deleteById(id);
    }

    @GetMapping("/GetUsersByName/{name}")
    public List<User> GetUsersByName(@PathVariable String name) {
        return  userDataAccess.GetUsersByName(name);
    }


}
