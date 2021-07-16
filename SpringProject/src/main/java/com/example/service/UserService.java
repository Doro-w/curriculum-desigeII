package com.example.service;

import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
public interface UserService extends IService<User> {
    int addUser(User user); // 注册时
    User getUserByNameAndPwd(String name, String password); // 登录时
    List<User> getUserId(String name);    // 根据用户名查找用户id
    int updateUser(int id, String name, String password);  //修改用户信息
}
