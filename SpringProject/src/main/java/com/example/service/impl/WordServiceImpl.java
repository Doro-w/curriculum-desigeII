package com.example.service.impl;

import com.example.entity.Word;
import com.example.mapper.WordMapper;
import com.example.service.WordService;
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
@Service("WordService")
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements WordService {

}
