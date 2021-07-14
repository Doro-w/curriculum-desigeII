package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
public interface UserMapper extends BaseMapper<User> {

    @Query("select user from User user where user.name=:username and user.password=:password")
    List<User> getUserByNameAndPwd(@Param("username") String username, @Param("password") String password);
}
