package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserByNameAndPwd(String username, String password);

    List<User> getUserIdByName(String username);

    int updateUserById(int id, String name, String password);
}
