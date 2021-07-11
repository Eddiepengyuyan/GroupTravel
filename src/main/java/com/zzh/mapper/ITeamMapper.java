package com.zzh.mapper;

import com.zzh.domain.Teams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ITeamMapper {
    @Select("select * from team;")
    List<Teams> findAllTeams();

    @Insert("insert into team(leaderid,name,message) values (#{leaderid},#{name},#{message})")
    void addTeam(@Param("leaderid")int leaderId,
                 @Param("name") String name,
                 @Param("message") String message);
}
