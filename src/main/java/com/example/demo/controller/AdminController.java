package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.pojo.cheliang;
import com.example.demo.service.cheliangService;
import com.example.demo.vo.cheliangVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @Autowired
    private cheliangService CheliangService = null;
    @PostMapping(value = "/admin")
    @ResponseBody
    public cheliangVo adminshow(@RequestParam("city") String city, @RequestParam("zhandian") String zhandian, @RequestParam("gongjiaochehao") Long gongjiaochehao, @RequestParam("time")String time){
        if(city != null && zhandian != null && gongjiaochehao != null && time != null){
            cheliang Chengliang = new cheliang();
            cheliang CheliangVo = new cheliang();
            Chengliang.setcity(city);
            Chengliang.setgongjiaochehao(gongjiaochehao);
            Chengliang.settime(time);
            Chengliang.setzhandian(zhandian);
            CheliangVo = CheliangService.insertcheliang(Chengliang);
            return changeToVo(CheliangVo);
        }
        return null;
    }
    
    private cheliangVo changeToVo(cheliang Cheliang) {
        cheliangVo CheliangVo = new cheliangVo();
        CheliangVo.setid(Cheliang.getid());
        CheliangVo.setcity(Cheliang.getcity());
        CheliangVo.setgongjiaochehao(Cheliang.getgongjiaochehao());
        CheliangVo.settime(Cheliang.gettime());
        CheliangVo.setzhandian(Cheliang.getzhandian());
        // CheliangVo.setshuliang(Cheliang.getshuliang());
        return CheliangVo;
    }
    // 将PO列表转换为VO列表
    private List<cheliangVo> changeToVoes(List<cheliang> cheliangList) {
        List<cheliangVo> voList = new ArrayList<>();
        for (cheliang Cheliang : cheliangList) {
            cheliangVo CheliangVo = changeToVo(Cheliang);
            voList.add(CheliangVo);
        }
        return voList;
    }
}