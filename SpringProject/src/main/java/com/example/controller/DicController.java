package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Dic;
import com.example.entity.User;
import com.example.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzc
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/dic")
@CrossOrigin
public class DicController {
    @Autowired
    private DicService dicService;

    //获取某个用户的全部词书
    @GetMapping("/getDicAll")
    public HashMap<String, Object> getDicAll(@RequestParam(value = "userId") int userId){
        List<Dic> diclist = dicService.getDicAll(userId);
        JSONArray jsonArray = new JSONArray();
        if(diclist!=null){
            for(Dic i :diclist){
                String jsonStr = JSON.toJSONString(i);//将每一个dic转换为json字符串
                JSONObject jsonObject = JSON.parseObject(jsonStr);//将json字符串转换为json对象
                jsonObject.put("dicId", jsonObject.getString("id"));
                jsonObject.remove("id");
                jsonArray.add(jsonObject);//将JSONObject对象添加到Json数组中
            }
            return new HashMap<String, Object>(){{
                put("msg","success!");
                put("code","1");
                put("result",jsonArray);  //嵌套json
            }};
        }
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    //用户根据词书名字查询词书（模糊匹配%name%）
    @GetMapping("/getDicByName")
    public HashMap<String, Object> getDicByName(@RequestParam(value = "userId") int userId,
                                                @RequestParam(value = "name") String name){
        List<Dic> dicList = dicService.getDicByName(userId, name);
        JSONArray jsonArray = new JSONArray();
        if(dicList!=null){
            for(Dic i :dicList){
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
        else {
            return new HashMap<String, Object>(){{
                put("msg","fail!");
                put("code","0");
            }};
        }
    }

    //根据词书名和用户id查询词书id
    @GetMapping("/findDicId")
    public HashMap<String, Object> findUserId(@RequestParam(value = "userId") int userId,
                                              @RequestParam(value = "name")String name){
        HashMap<String, Object> m = new HashMap<>();
        try {
            List<Dic> dicList = dicService.getDicId(userId, name);
            Integer id = dicList.get(0).getId();
            HashMap<String, String> map = new HashMap<>();
            map.put("id",id.toString());
            if(dicList!=null){
                m.put("msg","success!");
                m.put("code","1");
                m.put("result", map);
            }
        }catch (Exception e){
            e.printStackTrace();
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }

    //增加词书
    @PostMapping("/addDic")
    public HashMap<String, Object> addDic(@RequestBody Dic dic){
        HashMap<String,Object> m=new HashMap<>();
        boolean flag = dicService.save(dic);
        if (flag){
            m.put("msg","success!");
            m.put("code","1");
        }
        else{
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }

    //删除词书
    @DeleteMapping("/deleteDic")
    public HashMap<String, Object> deleteDic(@RequestParam(value = "id") int id){
        HashMap<String,Object> m=new HashMap<>();
        boolean flag = dicService.removeById(id);
        if (flag){
            m.put("msg","success!");
            m.put("code","1");
        }
        else{
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }

    //修改词书
    @PutMapping("/updateDic")
    public HashMap<String, Object> updateDic(@RequestBody Dic dic){
        HashMap<String,Object> m=new HashMap<>();
        boolean flag = dicService.updateById(dic);
        if (flag){
            m.put("msg","success!");
            m.put("code","1");
        }
        else{
            m.put("msg","fail!");
            m.put("code","0");
        }
        return m;
    }

}

