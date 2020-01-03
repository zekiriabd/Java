package com.softweb.Controllers;

import com.softweb.redis.repositories.IUserRepo;
import com.softweb.redis.entities.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.TreeSet;

@RestController
@RequestMapping("api/redis/user")
public class UserRedisController {

    @Autowired
    private IUserRepo userRepo;

    @GetMapping("/getusers")
    public Iterable<UserR> getUser() {
        return userRepo.findAll();
    }

    @GetMapping("/getuserbyid/{id}")
    public Iterable<UserR> getUserById(@PathVariable String id) {
        TreeSet ids = new TreeSet<String>();
        ids.add(id);
        return userRepo.findAllById(ids);
    }

    @PostMapping("/setuser")
    public void setuser(@RequestBody UserR user) {
        userRepo.save(user);
    }

    @GetMapping("/deluser/{id}")
    public void delUser(@PathVariable String id) {
        userRepo.deleteById(id);
    }

}