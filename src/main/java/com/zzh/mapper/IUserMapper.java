package com.zzh.mapper;

import com.zzh.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserMapper {

    @Select("select * from user where number = #{number}")
    List<User> findByNumber(String number);

    /** 插入一条用户记录
     * @param username
     * @param password
     * @param realname
     * @param number
     */
    @Insert("insert into user (username,password,realname,number) values(#{username},#{password},#{realname},#{number})")
    void insert(@Param("username")String username,@Param("password") String password,
                @Param("realname")String realname,@Param("number") String number);

    /**通过用户名找id
     * @param username
     * @return
     */
    @Select("select id from user where username=#{username}")
    int findIdByName(String username);

    /**通过用户名找用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    /**通过id找用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(int id);

    /**通过活动id找用户id
     * @param actid
     * @return
     */
    @Select("select userid from act_user where activityid=#{actid}")
    List<Integer> findIdByActid(int actid);

    /**在act_user增加一条记录
     * @param actid
     * @param uid
     */
    @Insert("insert into act_user (activityid,userid) values (#{actid},#{uid})")
    void addUser(@Param("actid")int actid,@Param("uid") int uid);

    /**通过id找用户
     * @param leaderid
     * @return
     */
    @Select("select * from user where id = #{leaderid}")
    List<User> findByUid(int leaderid);

    /**通过userid列表查找用户
     * @param userIds
     * @return
     */
    @Select("<script> " +
            "select * from user where id in" +
            "<foreach collection='list' item='item' index='index' open='(' separator=',' close=')' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    List<User> findByIds(List<Integer> userIds);
}
