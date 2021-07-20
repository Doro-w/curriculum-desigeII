package com.example.controller;
import com.example.service.PieService;
import com.example.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pie")
@CrossOrigin
public class PieController {
    @Autowired
    private PieService pieService;

    @GetMapping("/getDicPie")
    public PieVO pieVOList(@RequestParam(value = "userId") int userId){
        PieVO pieVO = pieService.pieVOList(userId);
        return pieVO;
    }

}
