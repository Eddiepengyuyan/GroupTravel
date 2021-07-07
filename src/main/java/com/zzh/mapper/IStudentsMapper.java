package com.zzh.mapper;

import com.zzh.domain.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author 22505
 * 学生持久层接口
 */
@Mapper
public interface IStudentsMapper {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from students")
    List<Students> findAll();

    /**
     * 保存用户
     * @param student
     */
    void saveStudent(Students student);

    /**
     * 更新用户
     * @param student
     */
    void updateStudent(Students student);

    /**
     * 删除用户
     * @param id
     */
    void deleteStudent(int id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Students findById(int id);

    /**
     * 模糊查找
     * @param name
     * @return
     */
    List<Students> findByName(String name);

    /**
     * 查询总条数
     * @return
     */
    int findTotal();
}
