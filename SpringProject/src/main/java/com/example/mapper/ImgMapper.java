package com.example.mapper;

import com.example.entity.Img;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface ImgMapper extends BaseMapper<Img> {
    // 获取词书封面
    List<Img> getImg(int id);
    // 添加词书封面并返回id
    Integer insertImgAndGetId(@Param(value = "img")Img img);

}
