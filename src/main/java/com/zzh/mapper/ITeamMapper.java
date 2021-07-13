package com.zzh.mapper;

import com.zzh.domain.Teams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ITeamMapper {
    @Select("select * from team;")
    List<Teams> findAllTeams();

    @Insert("insert into team(leaderid,name,message) values (#{leaderid},#{name},#{message})")
    void addTeam(@Param("leaderid")int leaderId,
                 @Param("name") String name,
                 @Param("message") String message);

    @Select("select * from team where leaderid = #{uid}")
    List<Teams> findByLeaderId(int uid);

    @Select("select * from team")
    @Results({
            @Result(column = "leaderid",property = "leaderid"),
            @Result(column = "name",property = "name"),
            @Result(column = "message",property = "message"),
            @Result(
                    //被包含对象的变量名
                    property="user",
                    //被包含对象的实际数据类型
                    javaType = List.class,
                    //根据查询出的team表中的leaderid字段来查询user表
                    column = "leaderid",
                    /** many,@many 一对多查询的固定写法
                    *   select属性：指定调用哪个接口中的哪个查询方法
                    **/
                    many = @Many(select = "com.zzh.mapper.IUserMapper.findByUid")
            )
    })
    List<Teams> findAllTeamsAndLeaders();

    @Select("select * from team where name=#{name}")
    Teams findByName(String name);

    @Select("select * from team where id=#{id}")
    Teams findById(int id);

    @Insert("insert into team_user(teamid,uid) values(#{teamid},#{userid}) ")
    void addUser(@Param("teamid") int teamid,@Param("userid") int userid);
}
