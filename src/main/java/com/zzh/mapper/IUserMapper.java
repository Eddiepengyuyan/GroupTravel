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

    @Insert("insert into user (username,password,realname,number) values(#{username},#{password},#{realname},#{number})")
    void insert(@Param("username")String username,@Param("password") String password,
                @Param("realname")String realname,@Param("number") String number);

    @Select("select id from user where username=#{username}")
    int findIdByName(String username);

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select userid from act_user where activityid=#{actid}")
    List<Integer> findIdByActid(int actid);

    @Insert("insert into act_user (activityid,userid) values (#{actid},#{uid})")
    void addUser(@Param("actid")int actid,@Param("uid") int uid);
}
