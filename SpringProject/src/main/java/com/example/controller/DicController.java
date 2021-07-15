package com.example.controller;


import com.example.entity.Dic;
import com.example.entity.User;
import com.example.entity.Word;
import com.example.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/dic")
public class DicController {

    @Autowired
    private DicService dicService;

    @GetMapping("/list")
    public List<Dic> list(){
        return this.dicService.list();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return this.dicService.removeById(id);
    }

    @GetMapping("/find/{id}")
    public Dic find(@PathVariable("id") Integer id){
        return this.dicService.getById(id);
    }

    @PutMapping("/update")
    public boolean edit(@RequestBody Dic dic){
        return  this.dicService.updateById((dic));
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Dic dic){
        return this.dicService.save(dic);
    }

}



