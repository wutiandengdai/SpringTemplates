package com.leiye;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiye.model.User;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User getUser(@RequestParam(value="id", defaultValue="1") int id) {
        return new User(id);
    }

}