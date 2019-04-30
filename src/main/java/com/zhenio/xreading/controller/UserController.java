package com.zhenio.xreading.controller;

import com.zhenio.xreading.Played;
import com.zhenio.xreading.model.User;
import com.zhenio.xreading.service.UserServcie;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/api/")
public class UserController {
    @Autowired
    UserServcie userServcie;
    @PostMapping("user/login")
    public Played login(@RequestBody User user) {
        return userServcie.login(user.getName(), user.getPassword());
    }
    @GetMapping("user/register")
    public Played register(@RequestParam String name, @RequestParam String password,HttpRequest request) {
        URI uri = request.getURI();
        return userServcie.register(name, password);
    }
    @GetMapping("list")
    public Played list(){
        return userServcie.findAll();
    }

}
