package com.MecroECommerce.ApiGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class testController {

    @GetMapping("/test")
    public String getUsers() {
        return "test tes test";
    }

}