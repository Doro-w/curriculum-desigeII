package com.example.service;

import com.example.entity.EnWords;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
public interface EnWordsService extends IService<EnWords> {
    String getWordTranslation(String word);
}
