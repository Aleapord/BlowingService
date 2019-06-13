package com.example.sdad.demo.bean;
//用户实体类
public class User {
    //下列域与数据库表格中的列一一对应
    private int id;
    private String name;
    private String sex;
    private int age;
    private String comeFrom;
    private double scoreCur;
    private int rankCur;
    private String scoreDetail;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", comeFrom='" + comeFrom + '\'' +
                ", scoreCur=" + scoreCur +
                ", rankCur=" + rankCur +
                ", scoreDetail='" + scoreDetail + '\'' +
                ", groupCur=" + groupCur +
                '}';
    }

    public int getGroupCur() {
        return groupCur;
    }

    public void setGroupCur(int groupCur) {
        this.groupCur = groupCur;
    }

    private int groupCur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public double getScoreCur() {
        return scoreCur;
    }

    public void setScoreCur(double scoreCur) {
        this.scoreCur = scoreCur;
    }

    public int getRankCur() {
        return rankCur;
    }

    public void setRankCur(int rankCur) {
        this.rankCur = rankCur;
    }

    public String getScoreDetail() {
        return scoreDetail;
    }

    public void setScoreDetail(String scoreDetail) {
        this.scoreDetail = scoreDetail;
    }
}