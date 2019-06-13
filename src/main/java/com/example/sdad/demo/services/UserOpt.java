package com.example.sdad.demo.services;

import com.example.sdad.demo.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//对玩家列表执行相应操作
class UserOpt {
    static List<User> group(List<User> user,int groupNum) throws Exception {
        if (60 % groupNum != 0) {
            throw new Exception("CanNotGroupException");
        } else {
            //打乱
            Collections.shuffle(user);
            Iterator<User> iterator = user.iterator();
            int groups=60/groupNum;
            //每GroupNum为一组，写入组号
            for(int i=1;i<=groups;i++){
                if(iterator.hasNext()){
                    for (int j=1;j<=groupNum;j++){
                        iterator.next().setGroupCur(i);
                    }
                }
            }
            return user;
        }
    }

    static List<User> play(List<User> user) {

        //生成随机分数
        user.forEach(user1 -> {
            ScoreDetail scoreDetail =new ScoreDetail();
            user1.setScoreCur(scoreDetail.getTotalScore());
            user1.setScoreDetail(scoreDetail.getDetail());
        });

        return user;
    }

    //排名的具体实现
    static List<User> rank(List<User> user,int groupNum) throws Exception {
        if(60%groupNum!=0){
            throw new Exception("CanNotGroupException");
        }
        Iterator<User> iterator=user.iterator();
        List<Group> groups = new ArrayList<>();
        int group=60/groupNum;
        for (int i=1;i<=group;i++){
            Group g=new Group();
            g.setGroupId(i);
            if(iterator.hasNext()){
                for(int j=0;j<groupNum;j++){
                   User u=iterator.next();
                   g.ids.add(u.getId());
                   g.groupTotalScore+=u.getScoreCur();
                }
            }
            groups.add(g);
        }
        Collections.sort(groups);
        for(int i=0;i<group;i++){
            int finalI = i;
            groups.get(i).ids.forEach(e->{
                user.forEach(user1 -> {
                    if(user1.getId()==e){
                        user1.setRankCur(group-finalI);
                    }
                });
            });
        }
        return user;
    }
    //定义小组类，方便小组排名
    static class Group implements Comparable<Group>{

        int groupId;
        int groupTotalScore;

        List<Integer> ids;

        Group() {
            groupId=0;
            ids=new ArrayList<>();
        }

        void setGroupId(int groupId) {
            this.groupId = groupId;
        }
        //规定用总分来判断小组的大小关系
        @Override
        public int compareTo(Group o) {
            return this.groupTotalScore-o.groupTotalScore;
        }
    }
}