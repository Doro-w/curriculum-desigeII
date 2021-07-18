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
    // 获取已经复习了的单词
    List<Word> getRevdWord(int dicId);
    // 获取还没复习了的单词
    List<Word> getUnRevdWord(int dicId);
    // 查询单词（模糊查询）
    List<Word> getWord(String name, int dicId);
    // 删除单词
    int deleteWord(String name, int dicId);
    // 获取已经复习的单词的数目
    Integer getCountRecvWord(int dicId);
    // 获取已经复习的单词的数目
    Integer getCountUnRecvWord(int dicId);
}
