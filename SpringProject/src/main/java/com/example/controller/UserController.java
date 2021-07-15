package com.example.controller;


import com.example.entity.Dic;
import com.example.entity.User;
import com.example.entity.Word;
import com.example.service.DicService;
import com.example.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@MapperScan("com.example.mapper.UserMapper")
@RequestMapping("//user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录方法
    @PostMapping("/login")
    @ResponseBody

    public HashMap<String,String> login(@RequestBody Account account) throws IOException {
        //注意这里新建一个Account，不能用User，因为和实际上数据库中的User完全不同
        User u=UserService.getUserByNameAndPwd(account.username,account.password); //获取用户表的用户名和密码
        if(u!=null){
            return new HashMap<String,String>(){{
                put("msg","success!");
                put("code","1");
            }};
        }
        else {
            return new HashMap<String,String>(){{
                put("msg","error!");
                put("code","0");
            }};
        }
    }

    public static class Account{
        public String username;
        public String password;
    }

    //用户注册
    @PostMapping("reg")
    @ResponseBody
    public HashMap saveUser(@RequestBody User user) throws Exception{
        HashMap m=new HashMap();
        try {
            user.setCreatTime();// new Date()为获取当前系统时间
            UserService.addUser(user);
            m.put("msg","success!");
            m.put("code","1");
        } catch (Exception e) {
            e.printStackTrace();
            m.put("msg","error!");
            m.put("code","0");
        }
        return m;
    }

    @GetMapping("/list")
    public List<User> list(){

        return this.userService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){

        return this.userService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public User find(@PathVariable("id") Integer id){

        return this.userService.getById(id);

    }
    @PutMapping("/update")
    public boolean edit(@RequestBody User user){

        return  this.userService.updateById((user));
    }

    @PostMapping("/add")
    public boolean add(@RequestBody User user){

        return this.userService.save(user);
    }

}

