package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public HashMap<String, Object> login(@RequestParam(value = "name")String name,
                                         @RequestParam(value = "password")String password){
        User u = userService.getUserByNameAndPwd(name,password);
        String jsonStr = JSON.toJSONString(u);//将java对象转换为json字符串
        JSONObject map = JSON.parseObject(jsonStr);//将json字符串转换为json对象
        if(u!=null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result",map);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    //用户注册
    @PostMapping("reg")
    public HashMap<String,String> saveUser(@RequestBody User user) throws Exception{
        HashMap<String,String> m=new HashMap<>();
        try {
            LocalDateTime time = LocalDateTime.now();
            user.setCreateTime(time);// new Date()为获取当前系统时间
            int i = userService.addUser(user);
            if (i ==1){
                m.put("msg","success!");
                m.put("code","1");
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
    public HashMap<String, Object> findUserId(@RequestParam(value = "name")String name){
        List<User> u = userService.getUserId(name);
        Integer id = u.get(0).getId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id.toString());
        if(u!=null){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result", map);
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }


    @PutMapping("/update")
    public HashMap<String, Object> edit(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
                                        @RequestParam(value = "password") String password){
        int result = userService.updateUser(id, name, password);
        if(result > 0){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }
}

