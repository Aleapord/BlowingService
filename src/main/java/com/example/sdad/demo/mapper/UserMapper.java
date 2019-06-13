package com.example.sdad.demo.mapper;

import com.example.sdad.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
/*
与数据库的接口类，负责用SQL语句查询与修改数据库内容，调用下列函数就会执行对应的SQL语句
 */
@Mapper
@Component
public interface UserMapper {

    @Select("select * from tables")
    List<User> findUser();

    @Select("select * from tables order by groupCur")
    List<User> findUserOrderByGroup();

    @Select("select * from tables where id=#{id}")
    User findUserById(@Param("id") int id);

    @Select("select * from tables where groupCur=#{groupCur}")
    List<User> findUsersByGroup(@Param("groupCur") int groupCur);

    @Update("update tables set scoreCur=#{scoreCur} where id=#{id}")
    void updateScore(@Param("scoreCur") double scoreCor,@Param("id") int id);

    @Update("update tables set rankCur=#{rankCur} where id=#{id}")
    void updateRank(@Param("rankCur") int rankCur,@Param("id") int id);

    @Update("update tables set groupCur=#{groupCur} where id=#{id}")
    void updateGroup(@Param("groupCur") int groupCur,@Param("id") int id);

    @Update("update tables set scoreDetail=#{scoreDetail} where id=#{id}")
    void updateDetail(@Param("scoreDetail") String scoreDetail,@Param("id") int id);

    @Update("update tables set scoreCur=null,rankCur=null,groupCur=null,scoreDetail=null")
    int start();
}
