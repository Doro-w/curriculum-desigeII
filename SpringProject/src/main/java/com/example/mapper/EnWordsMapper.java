package com.example.mapper;

import com.example.entity.EnWords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@Repository
public interface EnWordsMapper extends BaseMapper<EnWords> {
    String getWordTranslation(String word);
}
