package com.example.sdad.demo.services;

import com.example.sdad.demo.bean.User;
import com.example.sdad.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//服务类，用于将接收Controller的请求，通过UserOpt类的操作得到玩家实体列表，并通过UserMapper类将信息更新到数据库
@Service
public class UserServices {
    @Autowired
    private UserMapper userMapper;


    public List<User> findUser(){
        return userMapper.findUser();
    }

    public List<User> findUserByGroup(){
        return userMapper.findUserOrderByGroup();
    }

    public User findUserById(int id){
        return userMapper.findUserById(id);
    }

    public List<User> findUserByGroup(int groupCur){
        return userMapper.findUsersByGroup(groupCur);
    }

    public int start(){
        return userMapper.start();
    }

    public int group(int groupNum) throws Exception {
        //获取玩家实体并进行相应操作
        List<User> users=UserOpt.group(findUser(),groupNum);
        users.forEach(e->{
            //更新数据（下列函数原理基本相同）
            userMapper.updateGroup(e.getGroupCur(),e.getId());
        });
        return 0;
    }

    public int play() {
        List<User> users=UserOpt.play(findUser());
        users.forEach(e->{
            userMapper.updateDetail(e.getScoreDetail(),e.getId());
            userMapper.updateScore(e.getScoreCur(),e.getId());
        });
        return 0;
    }

    public int rank(int groupNum) throws Exception {
        List<User> users=UserOpt.rank(findUserByGroup(),groupNum);
        users.forEach(e->{
            userMapper.updateRank(e.getRankCur(),e.getId());
        });
        return 0;
    }
}
