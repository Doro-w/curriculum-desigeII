package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.entity.Dic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
@Repository
public interface DicMapper extends BaseMapper<Dic> {
    List<Dic> getDicAll(int userId);
    List<Dic> getDicByName(int userId, String name);
    List<Dic> getDicId(int userId, String name);
}
