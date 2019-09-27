package Softwe3.GetWebApiRest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping("/getUsers")
    public String getUsers(){
        return "[{'userId':1,'name':'zekiri'},{'userId':1,'name':'aloui'}]";
    }
}
