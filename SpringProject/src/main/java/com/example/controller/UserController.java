package com.example.controller;


import com.example.entity.Dic;
import com.example.entity.User;
import com.example.entity.Word;
import com.example.service.DicService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录方法
    @GetMapping("/login")
    public HashMap<String, String> login(@RequestParam(value = "name")String name,
                                         @RequestParam(value = "password")String password){
        User u = userService.getUserByNameAndPwd(name,password);
        if(u!=null){
            return new HashMap<String,String>(){{
                put("msg","success!");
                put("code","1");
                put("result",u.toString());
            }};
        }
        else {
            return new HashMap<String,String>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    //用户注册
    @PostMapping("reg")
    @ResponseBody
    public HashMap<String,String> saveUser(@RequestBody User user) throws Exception{
        HashMap<String,String> m=new HashMap<>();
        try {
            LocalDateTime time = LocalDateTime.now();
            user.setCreateTime(time);// new Date()为获取当前系统时间
            int i = userService.addUser(user);
            if (i ==1){
                m.put("msg","success!");
                m.put("code","1");
                m.put("result", user.toString());
            }
            else{
                m.put("msg","fail!");
                m.put("code","0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }

    //根据用户名查找用户id
    @GetMapping("/findUserId")
    public HashMap<String, String> findUserId(@RequestParam(value = "name")String name){
        User u = userService.getUserId(name);
        int id = u.getId();
        if(u!=null){
            return new HashMap<String,String>(){{
                put("msg","success!");
                put("code","1");
                put("result",Integer.toString(id));
            }};
        }
        else {
            return new HashMap<String,String>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    @PutMapping("/update")
    public boolean edit(@RequestBody User user){

        return  this.userService.updateById((user));
    }

}
