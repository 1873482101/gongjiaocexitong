package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.pojo.cheliang;
import com.example.demo.service.cheliangService;
import com.example.demo.vo.cheliangVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class cheliangController {
    // 用户服务接口
    @Autowired
    private cheliangService CheliangService = null;

    @PostMapping(value = "/cheliangchaxun")
    public String cheliangshow(@RequestParam("city") String city, @RequestParam("zhandian") String zhandian, ModelMap map){
        if(city != null && zhandian != null){
            Long mytest = (long) 1;
            List<cheliang> cheliangs = CheliangService.getbycityzhandian(city,zhandian);
            for (cheliang Cheliang : cheliangs) {
                map.addAttribute("id"+String.valueOf(mytest), Cheliang.getid());
                map.addAttribute("gongjiaochehao"+String.valueOf(mytest), Cheliang.getgongjiaochehao());
                map.addAttribute("time"+String.valueOf(mytest),Cheliang.gettime());
                mytest++;
                if(mytest == 6)
                {
                    break;
                }
            }
            return "/cheliangchaxun";
        }
        return null;
    }

    @PostMapping(value = "/zhandianchaxun")
    public String zhandianshow(@RequestParam("city")String city,@RequestParam("gongjiaochehao")Long gongjiaochehao, ModelMap map){
        if(city != null && gongjiaochehao != null){
            Long mytest = (long) 1;
            List<cheliang> cheliangs = CheliangService.getbycitygongjiaochehao(city, gongjiaochehao);
            for (cheliang Cheliang : cheliangs) {
                map.addAttribute("id"+String.valueOf(mytest), Cheliang.getid());
                map.addAttribute("zhandian"+String.valueOf(mytest),Cheliang.getzhandian());
                map.addAttribute("time"+String.valueOf(mytest),Cheliang.gettime());
                mytest++;
                if(mytest == 6)
                {
                    break;
                }
            }
            return "/zhandianchaxun";
        }
        return null;
    }

    @PostMapping(value = "/shikebiaochaxun")
    public String timeshow(@RequestParam("city")String city,@RequestParam("gongjiaochehao")Long gongjiaochehao, ModelMap map){
        if(city != null && gongjiaochehao != null){
            //调用Service层进行数据查找
            Long mytest = (long) 1;
            List<cheliang> cheliangs = CheliangService.getbycitygongjiaochehao(city, gongjiaochehao);
            for (cheliang Cheliang : cheliangs) {
                map.addAttribute("id"+String.valueOf(mytest), Cheliang.getid());
                map.addAttribute("city"+String.valueOf(mytest), Cheliang.getcity());
                map.addAttribute("zhandian"+String.valueOf(mytest),Cheliang.getzhandian());
                map.addAttribute("gongjiaochehao"+String.valueOf(mytest), Cheliang.getgongjiaochehao());
                map.addAttribute("time"+String.valueOf(mytest),Cheliang.gettime());
                mytest++;
                if(mytest == 6)
                {
                    break;
                }
            }
            return "/shikebiaochaxun";
        }
        return null;
    }

    @GetMapping(value="/myshow/{id}")
    @ResponseBody
    public cheliangVo myshow(@PathVariable("id")Long id){
        cheliang Cheliang = CheliangService.getbyid(id);
        return changeToVo(Cheliang);
    }

    @GetMapping(value="/Delate/{id}")
    @ResponseBody
    public int deleteVo(@PathVariable("id")Long id){
        return CheliangService.deletecheliang(id);
    }

    // 转换PO变为VO
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
