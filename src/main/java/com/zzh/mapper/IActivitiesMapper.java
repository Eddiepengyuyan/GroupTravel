package com.zzh.mapper;

import com.zzh.domain.Activities;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface IActivitiesMapper {

    /**
     * 查找全部活动
     * @return
     */
    @Select("select * from activities where status != 3")
    List<Activities> findAll();

    /**
     * 在activities中添加一条记录
     * @param theme
     * @param start
     * @param date
     * @param number
     * @param fee
     * @param message
     * @param leaderid
     */
    @Insert("insert into activities (theme,start,date,number,fee,message,leaderid) values (#{theme},#{start},#{date},#{number},#{fee},#{message},#{leaderid})")
    void insert(@Param("theme")String theme, @Param("start")String start,
                @Param("date")String date,@Param("number") String number,
                @Param("fee")String fee,@Param("message") String message,@Param("leaderid") int leaderid);

    /**
     * 通过leaderid查找活动
     * @param leaderid
     * @return
     */
    @Select("select * from activities where leaderid=#{leaderid}")
    Activities findById(int leaderid);

    /**
     * 通过leaderid查找活动
     * @param lid
     * @return
     */
    @Select("select * from activities where leaderid=#{leaderid} and status!=3")
    List<Activities> findByLid(int lid);

    /**
     * 通过用户id查找活动
     * @param uid
     * @return
     */
    @Select("select activityid from act_user where userid=#{uid}")
    List<Integer> findActidByUid(int uid);

    /**
     * 通过team_id查找活动
     * @param teamid
     * @return
     */
    @Select("select actid from team_act where teamid=#{teamid}")
    List<Integer> findActidByTid(int teamid);

    /**
     * 同过id查找活动
     * @param actId
     * @return
     */
    @Select("select * from activities where id=#{actId}")
    Activities findActById(int actId);

    /**
     * 通过主题查找活动
     * @param theme
     * @return
     */
    @Select("select * from activities where theme=#{theme}")
    Activities findByTheme(String theme);

    /**
     * 删除活动，通过状态码的修改实现逻辑删除
     * @param actid
     */
    @Update("update activities set status = 3 where id=#{actid}")
    void deleteById(int actid);


    /**
     * 通过id列表查找正在进行和已经成立的活动列表
     * @param joiActId
     * @return
     */
    @Select("<script>" +
            "select * from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "and status in (0,1)" +
            "</script>")
    List<Activities> findActByIds1(List<Integer> joiActId);

    /**
     * 通过id列表查找正在进行和已经 成立 的 费用 列表
     * @param joiActId
     * @return
     */
    @Select("<script>" +
            "select fee from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "and status in (0,1)" +
            "</script>")
    List<Integer> findFeeByIds1(List<Integer> joiActId);

    /**
     * 通过id列表查找已经 结束 的 活动 的列表
     * @param joiActId
     * @return
     */
    @Select("<script>" +
            "select * from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "and status=2" +
            "</script>")
    List<Activities> findActByIds2(List<Integer> joiActId);

    /**
     * 通过id列表查找已经 结束 的 费用 的列表
     * @param joiActId
     * @return
     */
    @Select("<script>" +
            "select * from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "and status=2" +
            "</script>")
    List<Integer> findFeeByIds2(List<Integer> joiActId);

    /**
     * 通过id列表查询活动列表
     * @param joiActId
     * @return
     */
    @Select("<script>" +
            "select * from activities where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "and status != 3" +
            "</script>")
    List<Activities> findActByIds(List<Integer> joiActId);

    /**
     * @param id
     * @param number
     * @param theme
     * @param time
     * @param start
     * @param fee
     * @param message
     *
     * 更新活动信息
     */
    @Update("update activities set number=#{number},theme=#{theme},date=#{time},start=#{start},fee=#{fee},message=#{message} where id=#{id}")
    void updateAct(@Param("id") int id, @Param("number") String number,
                   @Param("theme") String theme, @Param("time") String time,
                   @Param("start") String start, @Param("fee") String fee,
                   @Param("message") String message);

    /**
     * @param id
     *
     * 更新活动状态为已经 成立 的活动
     */
    @Update("update activities set status = 1 where id=#{id}")
    void setupAct(int id);

    /**
     * @param id
     *
     * 更新活动状态为已经 结束 的活动
     */
    @Update("update activities set status = 2 where id=#{id}")
    void closeAct(int id);

    /**
     * @param id
     * @return
     *
     * 统计参与活动人数
     */
    @Select("select count(userid) from act_user where activityid = #{id}")
    int countUserByActId(int id);

    /**
     * @return
     *
     * 统计所有人数
     */
    @Select("<script>" +
            "select count(userid) from act_user where activityid in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "group by activityid" +
            "</script>")
    List<Integer> countAllUser(List<Integer> joiActId);

    /**
     * @param actId
     * @param userId
     * @return
     *
     * 获取追加费用
     */
    @Select("select zj_perfee from act_user where activityid=#{actId} and userid=#{userId}")
    int getZjperfee(@Param("actId") int actId,@Param("userId") int userId);

    @Select("select aa_perfee from act_user where activityid=#{actId} and userid=#{userId}")
    int getAaperfee(@Param("actId") int actId,@Param("userId") int userId );

    /**
     * @param zjAfter
     * 
     * 更新追加费用
     */
    @Update("update act_user set zj_perfee = #{zjAfter} where activityid=#{actId} and userid = #{userId}")
    void addZjperfee(@Param("zjAfter")int zjAfter,@Param("actId")int actId,@Param("userId")int userId);

    /**
     * @param feePerUser
     *
     * 更新aa费用
     */
    @Update("update act_user set aa_perfee = #{feePerUser} where activityid=#{actid}")
    void addAaperfee(@Param("feePerUser")int feePerUser,@Param("actid") int actId);
}
