package com.softweb.Controllers;


import com.softweb.services.database.IUserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.softweb.dto.UserDto;


@RestController
@RequestMapping("api/db/user")
public class UserDbController {

    @Autowired
    private IUserDbService userService;

    @GetMapping("/getusers")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/getuserbyid/{id}")
    public UserDto GetUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @GetMapping("/getuserbyname/{name}")
    public List<UserDto> GetUsersByName(@PathVariable String name) {
        return  userService.getUsersByName(name);
    }

    @PostMapping("/PostUser")
    public void PostUser(@RequestBody UserDto user) {
        userService.setUser(user);
    }

    @PostMapping("/updateuser")
    public void updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @GetMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
