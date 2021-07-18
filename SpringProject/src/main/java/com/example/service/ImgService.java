package com.example.service;

import com.example.entity.Img;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
public interface ImgService extends IService<Img> {
    //获取词书封面
    List<Img> getImg(int id);
    // 添加词书封面并返回id
    Integer insertImgAndGetId(Img img);
}
