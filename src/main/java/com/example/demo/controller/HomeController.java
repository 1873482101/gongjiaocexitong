package com.example.demo.controller;

//import java.util.HashMap;

import com.example.demo.enumeration.SexEnum;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import ch.qos.logback.core.joran.conditional.ElseAction;

@Controller
public class HomeController {
   
    // 用户服务接口
	@Autowired
	private UserService userService = null;

    @RequestMapping("/pass")                                                    //请求页面响应
    public String passHtml(){
        return "/pass";
    }
    @RequestMapping("/zhuce")                                                   //请求页面响应
    public String zhuceHtml(){
        return "/zhuce";
    }

    @PostMapping(value = "/zhuce1")                                             //注册
    public String zhuce1(@RequestParam("myname")String userName,@RequestParam("mypass")String password,@RequestParam("sex")String sex){
        if(userName != null && password != null && sex != null){
            User user = userService.getUserbyName(userName);
            User myUser = new User();
            if(user == null){                                               //查无此用户，可以注册
                if(sex.equals("男"))
                {
                    System.out.println("男");
                    SexEnum mysex = SexEnum.getSexEnum(0);
                    myUser.setSex(mysex);
                    myUser.setNote(password);
                    myUser.setUserName(userName);
                    userService.insertUser(myUser);
                }
                else if(sex.equals("女"))
                {
                    System.out.println("女");
                    SexEnum mysex = SexEnum.getSexEnum(1);
                    myUser.setSex(mysex);
                    myUser.setNote(password);
                    myUser.setUserName(userName);
                    userService.insertUser(myUser);
                }
                else{
                    return "/zhuce2";
                }
                return "/welcome";
            }
            else{
                return "/zhuce2";
            }
        }
        return "/zhuce2";
    }
    
    @PostMapping(value = "/denglu")                                                 //登录
    public String denglu(@RequestParam("name")String userName,@RequestParam("password")String password){
        if(userName != null && password != null)
        {
            User user = userService.getUserbyName(userName);
            if(user.getNote().equals(password) == true){                           //密码一致
                return "/welcome";
            }
        }
        return "/passagain";                                                      //返回登录页面
    }
    @GetMapping("/cheliangchaxun")
    public String cheliangchaxunHtml(){
        return "/cheliangchaxun";
    }
    @GetMapping("/zhandianchaxun")
    public String zhandianchaxunHtml(){
        return "/zhandianchaxun";
    }
    @GetMapping("/shikebiaochaxun")
    public String shikebiaochaxunHtml(){
        return "/shikebiaochaxun";
    }
    @RequestMapping("/lianxiwomen")
    public String lianxiwomenHtml(){
        return "/lianxiwomen";
    }
    // 转换PO变为VO
	private UserVo changeToVo(User user) {
		UserVo userVo = new UserVo();
		userVo.setId(user.getId());
		userVo.setUserName(user.getUserName());
		userVo.setSexCode(user.getSex().getCode());
		userVo.setSexName(user.getSex().getName());
		userVo.setNote(user.getNote());
		return userVo;
	}

	// 转换Vo变为PO
	private User changeToPo(UserVo userVo) {
		User user = new User();
		user.setId(userVo.getId());
		user.setUserName(userVo.getUserName());
		user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
		user.setNote(userVo.getNote());
		return user;
	}
}