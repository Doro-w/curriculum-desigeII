package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Dic;
import com.example.entity.Word;
import com.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/word")
@CrossOrigin
public class WordController {
    @Autowired
    private WordService wordService;

    //获取某本词书里的全部单词
    @GetMapping("/getWordAll")
    public HashMap<String, Object> getWordAll(@RequestParam(value = "dicId") int dicId){
        JSONArray jsonArray = new JSONArray();
        List<Word> wordList = wordService.getWordAll(dicId);
        for(Word i :wordList){
            String jsonStr = JSON.toJSONString(i);//将每一个dic转换为json字符串
            JSONObject jsonObject = JSON.parseObject(jsonStr);//将json字符串转换为json对象
            jsonArray.add(jsonObject);//将JSONObject对象添加到Json数组中
        }
        return new HashMap<String, Object>(){{
            put("msg","success!");
            put("code","1");
            put("result",jsonArray);  //嵌套json
        }};
    }

    //获取某本词书里的已经复习了的单词
    @GetMapping("/getRevdWord")
    public HashMap<String, Object> getRevdWord(@RequestParam(value = "dicId") int dicId){
        JSONArray jsonArray = new JSONArray();
        List<Word> wordList = wordService.getRevdWord(dicId);
        for(Word i :wordList){
            String jsonStr = JSON.toJSONString(i);//将每一个dic转换为json字符串
            JSONObject jsonObject = JSON.parseObject(jsonStr);//将json字符串转换为json对象
            jsonArray.add(jsonObject);//将JSONObject对象添加到Json数组中
        }
        return new HashMap<String, Object>(){{
            put("msg","success!");
            put("code","1");
            put("result",jsonArray);  //嵌套json
        }};
    }

    //获取某本词书里的未复习了的单词
    @GetMapping("/getUnRevdWord")
    public HashMap<String, Object> getUnRevdWord(@RequestParam(value = "dicId") int dicId){
        JSONArray jsonArray = new JSONArray();
        List<Word> wordList = wordService.getUnRevdWord(dicId);
        for(Word i :wordList){
            String jsonStr = JSON.toJSONString(i);//将每一个dic转换为json字符串
            JSONObject jsonObject = JSON.parseObject(jsonStr);//将json字符串转换为json对象
            jsonArray.add(jsonObject);//将JSONObject对象添加到Json数组中
        }
        return new HashMap<String, Object>(){{
            put("msg","success!");
            put("code","1");
            put("result",jsonArray);  //嵌套json
        }};
    }

    //添加单词
    @PostMapping("/addWord")
    public HashMap<String, Object> addWord(@RequestBody Word word){
        HashMap<String,Object> m = new HashMap<>();
        int flag = wordService.addWord(word);
        if(flag == 1){
            m.put("msg","success!");
            m.put("code","1");
        }
        else{
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }


    //根据单词查询单词内容（字符串模糊查询）
    @GetMapping("/getWord")
    public HashMap<String, Object> getWord(@RequestParam(value = "name")String name, @RequestParam(value = "dicId") int dicId){
        JSONArray jsonArray = new JSONArray();
        List<Word> wordList = wordService.getWord(name, dicId);
        for(Word i :wordList){
            String jsonStr = JSON.toJSONString(i);//将每一个dic转换为json字符串
            JSONObject jsonObject = JSON.parseObject(jsonStr);//将json字符串转换为json对象
            jsonArray.add(jsonObject);//将JSONObject对象添加到Json数组中
        }
        return new HashMap<String, Object>(){{
            put("msg","success!");
            put("code","1");
            put("result",jsonArray);  //嵌套json
        }};
    }

    //删除词书单词
    @DeleteMapping("/deleteWord")
    public HashMap<String, Object> deleteWord(@RequestParam(value = "name")String name, @RequestParam(value = "dicId") int dicId){
        int result = wordService.deleteWord(name, dicId);
        if(result > 0){
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

}

