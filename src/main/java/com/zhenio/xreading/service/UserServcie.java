package com.zhenio.xreading.service;

import com.zhenio.xreading.Played;
import com.zhenio.xreading.mapper.UserMapper;
import com.zhenio.xreading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServcie {
    private final UserMapper dao;

    @Autowired
    public UserServcie(UserMapper dao) {
        this.dao = dao;
    }

    public boolean insert(User user) {
        return dao.inser(user) > 0;
    }

    public User findUserId(int id) {
        return dao.findById(id);
    }

    public Played findAll() {
        List<User> users = dao.findAll();
        return Played.isOk(users);
    }


    public Played register(String name, String password) {
        User user = dao.findByName(name);
        if (user != null) {
            return Played.isError("当前用户名已存在", 401);
        }
        if (user == null) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setPassword(password);

            int inser = dao.inser(newUser);

            if (inser > 0) {
                newUser.setPassword("");
                return Played.isOk("注册成功", newUser);
            }
        }
        return Played.isError(402, "注册失败！请稍后当前系统故障");
    }

    public Played login(String name, String password) {
        User user = dao.findByName("name");
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return Played.isOk(user);

            } else {
                return Played.isError(202, "密码不正确");
            }
        } else {

            return Played.isError(201, "用户不存在");
        }
    }

    public Played paging(int count, int row, int page) {

        return null;
    }
}
