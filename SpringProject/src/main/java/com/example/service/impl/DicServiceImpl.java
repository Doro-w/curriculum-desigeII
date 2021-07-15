package com.example.service.impl;

import com.example.entity.Dic;
import com.example.entity.User;
import com.example.mapper.DicMapper;
import com.example.service.DicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@Service
@Transactional
public class DicServiceImpl extends ServiceImpl<DicMapper, Dic> implements DicService {
    @Resource
    private  DicMapper dicMapper;
    @Override
    public List<Dic>  selectAllDic(Integer user_id, Integer offset, Integer limit) {
        return dicMapper.selectAll(user_id,offset,limit);
    }

    }

