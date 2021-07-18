package com.example.service.impl;

import com.example.entity.Dic;
import com.example.mapper.DicMapper;
import com.example.service.DicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
@Service("DicService")
public class DicServiceImpl extends ServiceImpl<DicMapper, Dic> implements DicService {
    @Autowired
    private DicMapper dicMapper;

    public List<Dic> getDicAll(int userId){
        List<Dic> dic = dicMapper.getDicAll(userId);
        if(dic.size()>0){
            return dic;
        }
        return null;
    }

    public List<Dic> getDicByName(int userId, String name){
        List<Dic> dic = dicMapper.getDicByName(userId, name);
        if(dic.size()>0){
            return dic;
        }
        return null;
    }

    public List<Dic> getDicId(int userId, String name){
        List<Dic> dic = dicMapper.getDicId(userId, name);
        if(dic.size()>0){
            return dic;
        }
        return null;
    }
}
