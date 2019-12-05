package com.softweb.Controllers;

import com.softweb.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.softweb.dto.UserDto;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getusers")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.GetUsers());
    }
}
