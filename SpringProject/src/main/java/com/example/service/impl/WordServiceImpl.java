package com.example.service.impl;

import com.example.entity.Word;
import com.example.mapper.WordMapper;
import com.example.service.WordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@Service("WordService")
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements WordService {
    @Autowired
    private WordMapper wordMapper;

    @Override
    public List<Word> getWordAll(int dicId){
        return wordMapper.getWordAll(dicId);
    }

    @Override
    public int addWord(Word word){
        return wordMapper.insert(word);
    }

    @Override
    public  List<Word> getRevdWord(int dicId){
        return wordMapper.getRevdWord(dicId);
    }

    @Override
    public List<Word> getUnRevdWord(int dicId){
        return wordMapper.getUnRevdWord(dicId);
    }

    @Override
    public List<Word> getWord(String name, int dicId){
        return wordMapper.getWord(name,dicId);
    }

    @Override
    public int deleteWord(String name, int dicId){
        return wordMapper.deleteWord(name, dicId);
    }

    // 获取已经复习的单词的数目
    @Override
    public Integer getCountRecvWord(int dicId){
        try {
            Integer count = wordMapper.getCountRecvWord(dicId);
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    // 获取还没复习的单词的数目
    @Override
    public Integer getCountUnRecvWord(int dicId){
        try{
            Integer count = wordMapper.getCountUnRecvWord(dicId);
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    //修改单词学习状态
    @Override
    public Integer changeStatus(int wordId){
        try{
            return wordMapper.changeStatus(wordId);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

}
