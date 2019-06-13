package com.example.sdad.demo.controller;

import com.example.sdad.demo.bean.User;
import com.example.sdad.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
本类是SpringBoot应用的Controller类，用于接收Http请求，并调用service的相应函数对数据库进行操作
 */
@RestController
@RequestMapping()
public class UserController {


    @Autowired
     private UserServices services;

    //http://207.148.101.11:8080/ （返回所有玩家的数据）
    @GetMapping("/")
    public List<User> findUser(){
        return services.findUser();
    }
    //http://207.148.101.11:8080/ById?id= （通过id查询玩家信息）
    @GetMapping("/ById")
    public User findUserById(int id){
        return services.findUserById(id);
    }
    //http://207.148.101.11:8080/start  （清除所有玩家得分信息）
    @GetMapping("/start")
    public int start(){
        return  services.start();
    }
    //http://207.148.101.11:8080/selectGroup?groupNum=  （通过组号查询一组玩家信息）
    @GetMapping("/selectGroup")
    public List<User> selecGroup(int groupNum){
        return services.findUserByGroup(groupNum);
    }
    //http://207.148.101.11:8080/group?groupNum=  （给所有玩家分组）
    @GetMapping("/group")
    public int group(int groupNum) throws Exception {
            return services.group(groupNum);
    }
    //http://207.148.101.11:8080/play  （生成随机分数）
    @GetMapping("/play")
    public int play(){
        return services.play();
    }
    //http://207.148.101.11:8080/rank?groupNum=  （给所有玩家按小组排名）
    @GetMapping("/rank")
    public int rank(int groupNum) throws Exception {
        return services.rank(groupNum);
    }
}
