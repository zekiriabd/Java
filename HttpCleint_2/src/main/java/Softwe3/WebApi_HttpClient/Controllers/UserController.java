package Softwe3.WebApi_HttpClient.Controllers;

import Softwe3.WebApi_HttpClient.Models.User;
import Softwe3.WebApi_HttpClient.Services.UserService;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService = new UserService();

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.GetUsers();
    }

    @PostMapping("/SetUser")
    public void SetUser(@RequestBody User user) {
        userService.PostUser(user);
    }


}
