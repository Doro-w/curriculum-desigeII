package com.example.service;

import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
    User getUserId(String name);    // 根据用户名查找用户id
}
