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
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // 注册时
    @Override
    public User addUser(User user){
        try{
            return UserMapper.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUser(int id){
        try {
            UserMapper.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 登录时
    @Autowired
    List<User> userList;
    @Override
    public User getUserByNameAndPwd(String username, String password){
        List<User> user=userList;
        if(user.size()>0){
            return user.get(0);
        }
        return null;
    }

    // 根据用户名查找用户id
    @Override
    public User getUserId(String username){
        List<User> user=UserMapper.getUserByName(username);
        if(user.size()>0){
            return user.get(0);
        }
        return null;
    }
}
