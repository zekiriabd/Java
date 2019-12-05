package com.softweb.Controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.softweb.UserService;
import com.softweb.UserDto;
import com.softweb.IUserService;



@RestController
@RequestMapping("api/user")
public class UserController {

    //@Autowired private IUserService userService;
    private UserService userService = new UserService();

    @GetMapping("/getUsersfromapi")
    public UserDto[] GetUsers() {

        return userService.GetUsers();
    }

    @PostMapping("/SetUserToapi")
    public void SetUser(@RequestBody UserDto user) {

        userService.PostUser(user);
    }

    @GetMapping("/getdbusers")
    public List<UserDto> getusers() {

        return userService.GetdbUsers();
    }

    @PostMapping("/PostUser")
    public void PostUser(@RequestBody UserDto user) {

        userService.PostdbUser(user);
    }

    @PostMapping("/UpdateUser")
    public void updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @GetMapping("/GetUserById/{id}")
    public Optional<UserDto> GetUserById(@PathVariable int id) {
        return userService.GetUserById(id);
    }

    @GetMapping("/delUser/{id}")
    public void delUser(@PathVariable int id) {
        userService.delUser(id);
    }

    @GetMapping("/GetUsersByName/{name}")
    public List<UserDto> GetUsersByName(@PathVariable String name) {

        return  userService.GetUsersByName(name);
    }


}
