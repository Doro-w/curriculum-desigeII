package com.example.controller;


import com.example.service.EnWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzc
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/enWords")
@CrossOrigin
public class EnWordsController {
    @Autowired
    private EnWordsService enWordsService;

    @GetMapping("/getTranslation")
    public HashMap<String, Object> getTranslation(@RequestParam(value = "word") String word){
        HashMap<String, Object> m = new HashMap<>();
        String translation = enWordsService.getWordTranslation(word);
        if(translation!=null){
            HashMap<String, String> map = new HashMap<>();
            map.put("translation",translation);
            m.put("msg","success!");
            m.put("code","1");
            m.put("result", map);
        }
        else {
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }
}

