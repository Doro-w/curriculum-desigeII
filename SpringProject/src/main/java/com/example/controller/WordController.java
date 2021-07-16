package com.example.controller;


import com.example.entity.Word;
import com.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzc
 * @since 2021-07-14
 */
@RestController

@RequestMapping("//word")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping("/list")
    public List<Word> list(){
        return this.wordService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return this.wordService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Word find(@PathVariable("id") Integer id){
        return this.wordService.getById(id);
    }

    @PutMapping("/update")
    public boolean edit(@RequestBody Word word){
        return  this.wordService.updateById((word));
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Word word){
        return this.wordService.save(word);
    }
}


