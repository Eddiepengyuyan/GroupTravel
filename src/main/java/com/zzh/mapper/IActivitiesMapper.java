package com.zzh.mapper;

import com.zzh.domain.Activities;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface IActivitiesMapper {

    @Select("select * from activities")
    List<Activities> findAll();

    @Insert("insert into activities (theme,start,date,number,fee,message,leaderid) values (#{theme},#{start},#{date},#{number},#{fee},#{message},#{leaderid})")
    void insert(@Param("theme")String theme, @Param("start")String start,
                @Param("date")String date,@Param("number") String number,
                @Param("fee")String fee,@Param("message") String message,@Param("leaderid") int leaderid);

    @Select("select * from activities where leaderid=#{leaderid}")
    Activities findById(int leaderid);

    @Select("select * from activities where leaderid=#{leaderid}")
    List<Activities> findByLid(int lid);

    @Select("select activityid from act_user where userid=#{uid}")
    List<Integer> findActidByUid(int uid);

    @Select("select * from activities where id=#{actId}")
    Activities findActById(int actId);

    @Select("select * from activities where theme=#{theme}")
    Activities findByTheme(String theme);

    @Delete("delete from activities where id=#{actid}")
    void deleteById(int actid);

    @Select("<script>" +
            "select * from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    List<Activities> findActByIds(List<Integer> joiActId);
}
