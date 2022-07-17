package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@Api(tags = "用户鉴权接口")
@CrossOrigin("*")
@RestController
public class UserController {
    Gson gson = new Gson();
    @Autowired
    private UserMapper userMapper;

    // 登录
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        if (userMapper.selectOne(userQueryWrapper) == null) {
            return "error";
        }
        String token = TokenUtil.getToken(user.getUsername());
        HashMap<String, String> res = new HashMap<>();
        res.put("username", user.getUsername());
        res.put("token", token);
        return gson.toJson(res);
    }

    // 注册
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userMapper.insert(user);
        String token = TokenUtil.getToken(user.getUsername());
        HashMap<String, String> res = new HashMap<>();
        res.put("username", user.getUsername());
        res.put("token", token);
        return gson.toJson(res);
    }

    // 校验token
    @PostMapping("/checkToken")
    public String checkToken(@RequestBody HashMap<String, String> data) {
        String username = data.get("username");
        String token = data.get("token");
        if (username.equals(TokenUtil.parseToken(token))) {
            return "1";
        }
        return "0";
    }
}
