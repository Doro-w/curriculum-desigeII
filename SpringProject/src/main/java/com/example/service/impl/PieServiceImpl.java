package com.example.service.impl;

import com.example.entity.Dic;
import com.example.mapper.DicMapper;
import com.example.mapper.WordMapper;
import com.example.service.PieService;
import com.example.vo.PieDataVO;
import com.example.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("PieService")
public class PieServiceImpl implements PieService {
    @Autowired
    private DicMapper dicMapper;

    @Autowired
    private WordMapper wordMapper;

    @Override
    public PieVO pieVOList(int userId){
        List<Dic> dicList = dicMapper.getDicAll(userId);
        List<String> dicNameList = new ArrayList<>();
        List<PieDataVO> pieDataVOList = new ArrayList<>();
        for(Dic i : dicList){
            dicNameList.add(i.getName());
            Integer revd = wordMapper.getCountRecvWord(i.getId());
            Integer unRevd = wordMapper.getCountUnRecvWord(i.getId());

            HashMap<String, String> m = new HashMap<>();
            m.put("已经复习的单词数",revd.toString());
            m.put("还没复习的单词数",unRevd.toString());

            PieDataVO pieDataVO = new PieDataVO();
            pieDataVO.setData(m);

            pieDataVOList.add(pieDataVO);
        }
        PieVO pieVO = new PieVO();
        pieVO.setPieName(dicNameList);
        pieVO.setDataList(pieDataVOList);

        return pieVO;
    }
}
