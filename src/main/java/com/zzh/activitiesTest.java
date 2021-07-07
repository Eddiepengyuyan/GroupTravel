package com.zzh;

import com.zzh.domain.Activities;
import com.zzh.mapper.IActivitiesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootAutoDemoApplication.class)
public class activitiesTest {
    @Autowired
    private IActivitiesMapper iActivitiesMapper;

    @Test
    public void test() {
        List<Activities> a = iActivitiesMapper.findAll();
        System.out.println(a);
    }
}
