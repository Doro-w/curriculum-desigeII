package com.example.service;

import com.example.entity.Dic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
public interface DicService extends IService<Dic> {
    List<Dic> getDicAll(int userId);
    List<Dic> getDicByName(int userId, String name);
    List<Dic> getDicId(int userId, String name);
}
