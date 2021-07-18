package com.example.service;

import com.example.entity.Word;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
public interface WordService extends IService<Word> {
    List<Word> getWordAll(int dicId);
    int addWord(Word word);
    List<Word> getRevdWord(int dicId);
    List<Word> getUnRevdWord(int dicId);
    List<Word> getWord(String name, int dicId);
    int deleteWord(String name, int dicId);
}
