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

//    @GetMapping("/api/develop/home")
//    public String home(){
//        return JsonData.home_data;
//    }
//    @GetMapping("/api/develop/course")
//    public String courseDetail(){
//        return JsonData.course;
//    }
//    @GetMapping("/api/develop/user")
//    public String userInfo(){
//        return JsonData.userInfo;
//    }
//    @GetMapping("/api/develop/update")
//    public String  update(){
//        return  JsonData.update_data;
//    }
//    @GetMapping("/api/develop/splash")
//    public String splash(){
//        return JsonData.splash_ad_data;
//    }
//
//    @GetMapping("/api/develop/search")
//    public String search(){
//        return JsonData.search_data;
//    }

    @GetMapping("api")
    public Played list() {
        Map map = new HashMap<>();
        map.put("home", "/api/develop/home");
        map.put("user", "/api/develop/user");
        map.put("course", "/api/develop/course");
        map.put("update", "/api/develop/update");
        map.put("splash", "/api/develop/splash");
        map.put("search", "/api/develop/search");
        return Played.isOk(map);
    }
    @GetMapping("all")
    public Played all() {
        //查询数据
        return shareService.findAll();
    }


}
