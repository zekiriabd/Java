package com.softwe3.dockerjava;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class MyController {

    @GetMapping("/getmessage")
    public String getmessage() {

        return "Hello World";
    }
}