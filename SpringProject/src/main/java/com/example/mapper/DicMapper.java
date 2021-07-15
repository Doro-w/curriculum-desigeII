package com.example.mapper;

import com.example.entity.Dic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
=======
import org.springframework.stereotype.Repository;
>>>>>>> 828b63480cf68dbceba1728d9295d4ed2457e9f6

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@Repository
public interface DicMapper extends BaseMapper<Dic> {
    @Select("select * from dic where user_id = #{user_id}  limit #{offset},#{limit}")
    List<Dic> selectAll(Integer user_id, Integer offset, Integer limit);
}
