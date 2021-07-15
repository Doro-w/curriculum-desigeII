package com.example.service.impl;

import com.example.entity.Dic;
import com.example.mapper.DicMapper;
import com.example.service.DicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@Service("DicService")
public class DicServiceImpl extends ServiceImpl<DicMapper, Dic> implements DicService {

}
