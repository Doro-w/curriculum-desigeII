package com.example.service.impl;

import com.example.entity.EnWords;
import com.example.mapper.EnWordsMapper;
import com.example.service.EnWordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@Service("EnWords")
public class EnWordsServiceImpl extends ServiceImpl<EnWordsMapper, EnWords> implements EnWordsService {
    @Autowired
    private EnWordsMapper enWordsMapper;

    @Override
    public String getWordTranslation(String word){
        return enWordsMapper.getWordTranslation(word);
    }
}
