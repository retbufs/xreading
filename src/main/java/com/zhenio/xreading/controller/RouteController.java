package com.zhenio.xreading.controller;

import com.zhenio.xreading.Played;
import com.zhenio.xreading.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rx/api/")
public class RouteController {
    @PostMapping("login")
    public Played login(@RequestParam Map<String, String> params){
        return Played.isOk(params);
    }


}
