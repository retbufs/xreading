package com.zhenio.xreading.controller;

import com.zhenio.xreading.Played;
import com.zhenio.xreading.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/api/develop/")
public class DeveController {
    @Autowired
    ShareService shareService;


    @GetMapping("impl")
    public Played list() {
        Map map = new HashMap<>();
        map.put("home", "/api/develop/home");
        map.put("user", "/api/develop/user");
        map.put("course", "/api/develop/course");
        map.put("update", "/api/develop/update");
        map.put("splash", "/api/develop/splash");
        map.put("search", "/api/develop/search?wd={content}");
        return Played.isOk(map);
    }
    @GetMapping("home")
    public Played home() {
        Map map = new HashMap<>();
        map.put("head", "/api/develop/home/head");
        map.put("body", "/api/develop/home/body");
        map.put("video", "/api/develop/home/video");
        map.put("footer", "/api/develop/home/footer");
        map.put("time", "/api/develop/home/time");
        return Played.isOk(map);
    }
    @GetMapping("wd")
    public Played findAll(){
        return  shareService.findAll();
    }

}
