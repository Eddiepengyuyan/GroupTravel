package com.zzh;


import com.zzh.domain.Students;
import com.zzh.mapper.IStudentsMapper;
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

    @Test
    public void test() {
        List<Students> stus = iStudentsMapper.findAll();
        System.out.println(stus);
    }
}
