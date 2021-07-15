package com.zzh;


import com.zzh.domain.Activities;
import com.zzh.domain.Teams;
import com.zzh.domain.User;
import com.zzh.mapper.IActivitiesMapper;
import com.zzh.mapper.IStudentsMapper;
import com.zzh.mapper.ITeamMapper;
import com.zzh.mapper.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootAutoDemoApplication.class)
public class MybatisTest {

    @Autowired
    private IStudentsMapper iStudentsMapper;

    @Autowired
    private ITeamMapper iTeamMapper;

    @Autowired
    private IUserMapper iUserMapper;

    @Autowired
    private IActivitiesMapper iActivitiesMapper;

    @Test
    public void test() {
//        List<Students> stus = iStudentsMapper.findAll();
//        System.out.println(stus);
        List<Teams> teams = iTeamMapper.findAllTeamsAndLeaders();
        System.out.println(teams);
//        .get(0).getUser().get(0).getUsername()

    }

    @Test
    public void test1(){
        List<Integer> userIds = iTeamMapper.findUserIds(1);
        List<User> this_user = iUserMapper.findByIds(userIds);
        System.out.println(this_user);
    }

    @Test
    public void test2(){
        List<Integer> actid = iActivitiesMapper.findActidByUid(1);
        List<Activities> acts = iActivitiesMapper.findActByIds(actid);
        System.out.println(acts);
        List<Activities> acts1 = iActivitiesMapper.findActByIds1(actid);
        System.out.println(acts1);
        List<Activities> acts2 = iActivitiesMapper.findActByIds2(actid);
        System.out.println(acts2);

    }

    @Test
    public void test3(){
        List<Integer> actid = iActivitiesMapper.findActidByTid(1);
        System.out.println(actid);
        List<Activities> acts = iActivitiesMapper.findActByIds(actid);
        System.out.println(acts);
        List<Activities> acts1 = iActivitiesMapper.findActByIds1(actid);
        System.out.println(acts1);
        List<Activities> acts2 = iActivitiesMapper.findActByIds2(actid);
        System.out.println(acts2);

    }

    @Test
    public void test4(){
//        int i = iActivitiesMapper.countUserByActId(3);
//        System.out.println(i);
        List<Integer> actid = iActivitiesMapper.findActidByTid(1);
        List<Integer> is= iActivitiesMapper.countAllUser(actid);
        List<Integer> fe= iActivitiesMapper.findFeeByIds1(actid);

        System.out.println(is);
        System.out.println(fe.get(0));
    }
}
