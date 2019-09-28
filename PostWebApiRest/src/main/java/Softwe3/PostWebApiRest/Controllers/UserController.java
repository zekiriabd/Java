package Softwe3.PostWebApiRest.Controllers;

import Softwe3.PostWebApiRest.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/user")

public class UserController {

    @PostMapping("/SetUser")
    public void SetUser(@RequestBody User user){
        System.out.println("ID        : "  + user.getId());
        System.out.println("LastName  : "  + user.getLastName());
        System.out.println("FirstName : "  + user.getFirstName());
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Zekiri","Abdelali"));
        users.add(new User(2,"Ali","Aloui"));
        users.add(new User(3,"Raouf","Rahich"));
        return users;
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
