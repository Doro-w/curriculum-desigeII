package com.example.service;

import com.example.entity.Dic;
import com.baomidou.mybatisplus.extension.service.IService;
import sun.jvm.hotspot.types.CIntegerField;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
public interface DicService extends IService<Dic> {

    List<Dic>  selectAllDic(Integer user_id, Integer offset, Integer limit);
}
