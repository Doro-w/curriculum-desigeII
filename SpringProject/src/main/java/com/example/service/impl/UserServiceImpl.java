package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 注册时
    @Override
    public int addUser(User user){
        try{
            return userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    // 登录时
    @Override
    public User getUserByNameAndPwd(String username, String password){
        List<User> user=userMapper.getUserByNameAndPwd(username,password);
        if(user.size()>0){
            System.out.println(user.get(0));
            return user.get(0);
        }
        return null;
    }

    // 根据用户名查找用户id
    @Override
    public List<User> getUserId(String username){
        List<User> user = userMapper.getUserIdByName(username);
        if(user.size()>0){
            return user;
        }
        return null;
    }
}
