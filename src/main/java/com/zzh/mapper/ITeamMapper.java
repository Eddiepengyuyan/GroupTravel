package com.zzh.mapper;

import com.zzh.domain.Teams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ITeamMapper {
    /**查找所有团队
     * @return
     */
    @Select("select * from team;")
    List<Teams> findAllTeams();

    /**添加团队记录
     * @param leaderId
     * @param name
     * @param message
     */
    @Insert("insert into team(leaderid,name,message) values (#{leaderid},#{name},#{message})")
    void addTeam(@Param("leaderid")int leaderId,
                 @Param("name") String name,
                 @Param("message") String message);

    /**通过leaderid找到团队
     * @param uid
     * @return
     */
    @Select("select * from team where leaderid = #{uid}")
    List<Teams> findByLeaderId(int uid);

    /**一对多关联查询，找出team和团长的相关信息
     * @return
     */
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

    /**通过团队名找团队
     * @param name
     * @return
     */
    @Select("select * from team where name=#{name}")
    Teams findByName(String name);

    /**通过id找团队
     * @param id
     * @return
     */
    @Select("select * from team where id=#{id}")
    Teams findById(int id);

    /**往team_user中添加一条记录
     * @param teamid
     * @param userid
     */
    @Insert("insert into team_user(teamid,uid) values(#{teamid},#{userid}) ")
    void addUser(@Param("teamid") int teamid,@Param("userid") int userid);


    /**通过团队id找用户id
     * @param teamId
     * @return
     */
    @Select("select uid from team_user where teamid = #{teamId}")
    List<Integer> findUserIds(int teamId);

    @Insert("insert into team_act (teamid,actid) values (#{teamId},#{actId})")
    void addAct(@Param("teamId")int teamId,@Param("actId") int actId);
}
