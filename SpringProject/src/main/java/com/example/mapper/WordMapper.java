package com.example.mapper;

import com.example.entity.Word;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@Repository
public interface WordMapper extends BaseMapper<Word> {
    // 获取某本词书里的全部单词
    List<Word> getWordAll(int dicId);
    List<Word> getRevdWord(int dicId);
    List<Word> getUnRevdWord(int dicId);
    List<Word> getWord(String name, int dicId);
    int deleteWord(String name, int dicId);
}
