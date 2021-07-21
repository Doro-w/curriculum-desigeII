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
    // 获取已经复习的单词的数目
    Integer getCountRecvWord(int dicId);
    // 获取已经复习的单词的数目
    Integer getCountUnRecvWord(int dicId);
    //修改单词学习状态
    Integer changeStatus(int wordId);
}
